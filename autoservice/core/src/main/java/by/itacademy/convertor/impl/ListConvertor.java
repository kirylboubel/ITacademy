package by.itacademy.convertor.impl;

import by.itacademy.convertor.Convert;
import by.itacademy.transport.annotation.Parameter;
import by.itacademy.transport.transport.Transport;
import by.itacademy.convertor.ValidationException;
import org.json.JSONObject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class ListConvertor implements Convert {

    @Override
    public List<JSONObject> convertToProcessedJsonTransports(final List<Transport> transportList, final Comparator<Transport> comparator) {
        return getJsonList(transportList, (transport) -> {
                    try {
                        return isValid(transport);
                    } catch (ValidationException e) {
                        throw new RuntimeException(e);
                    }
                }, true,
                comparator);
    }

    @Override
    public List<JSONObject> convertToInvalidJsonTransports(final List<Transport> transportList, final Comparator<Transport> comparator) {
        return getJsonList(transportList, (transport) -> {
                    try {
                        return !isValid(transport);
                    } catch (ValidationException e) {
                        throw new RuntimeException(e);
                    }
                }, false,
                comparator);
    }

    private static List<JSONObject> getJsonList(
            final List<Transport> transportList,
            final Predicate<Transport> predicate,
            final boolean isValid,
            Comparator<Transport> comparator
    ) {
        return transportList.stream()
                .sorted(comparator)
                .filter(predicate)
                .map(transport -> createJsonObject(transport, isValid))
                .toList();
    }

    private static boolean isValid(final Transport transport) throws ValidationException {
        boolean isValid = false;

        for (final Field field : transport.getClass().getDeclaredFields()) {
            for (final Annotation annotation : field.getDeclaredAnnotations()) {
                if (!(annotation instanceof Parameter)) {
                    continue;
                }
                if (!field.canAccess(transport) && !field.trySetAccessible()) {
                    continue;
                }
                final Parameter parameter = (Parameter) annotation;
                try {
                    final Object fieldType = field.get(transport);
                    if (!(fieldType instanceof String)) {
                        continue;
                    }
                    final String name = (String) fieldType;
                    final Predicate<String> predicate = Pattern.compile(parameter.pattern()).asPredicate();

                    isValid = predicate.test(name);
                } catch (IllegalAccessException e) {
                    throw new ValidationException("Failed to validate Parameter annotation", e);
                }
            }
        }
        return isValid;
    }

    private static JSONObject createJsonObject(final Transport transport, final boolean isValid) {
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", transport.getTransportType());
        jsonObject.put("name", transport.getTransportName());

        if (isValid) {
            jsonObject.put("cost", transport.getTransportTax());
        }
        return jsonObject;
    }
}

