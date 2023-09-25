//package by.itacademy.validator.impl;
//
//import by.itacademy.transport.annotation.Parameter;
//import by.itacademy.transport.transport.Transport;
//import by.itacademy.validator.Validation;
//import by.itacademy.validator.ValidationException;
//
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Field;
//import java.util.function.Predicate;
//import java.util.regex.Pattern;
//
//public class TransportValidator implements Validation {
//    @Override
//    public boolean isValid(Transport transport) throws ValidationException {
//        boolean isValid = false;
//
//        for (final Field field : transport.getClass().getDeclaredFields()) {
//            for (final Annotation annotation : field.getDeclaredAnnotations()) {
//                if (!(annotation instanceof Parameter)) {
//                    continue;
//                }
//                if (!field.canAccess(transport) && !field.trySetAccessible()) {
//                    continue;
//                }
//                final Parameter parameter = (Parameter) annotation;
//                try {
//                    final Object fieldType = field.get(transport);
//                    if (!(fieldType instanceof String)) {
//                        continue;
//                    }
//                    final String name = (String) fieldType;
//                    final Predicate<String> predicate = Pattern.compile(parameter.pattern()).asPredicate();
//
//                    isValid = predicate.test(name);
//                } catch (IllegalAccessException e) {
//                    throw new ValidationException("Failed to validate Parameter annotation", e);
//                }
//            }
//        }
//        return isValid;
//    }
//}
