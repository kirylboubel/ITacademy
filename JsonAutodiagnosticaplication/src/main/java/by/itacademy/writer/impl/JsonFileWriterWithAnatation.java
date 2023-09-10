package by.itacademy.writer.impl;

import by.itacademy.annotation.Parametr;
import by.itacademy.transport.Transport;
import by.itacademy.writer.AnatationDataWriter;
import by.itacademy.writer.DataWriterException;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.List;

public class JsonFileWriterWithAnatation implements AnatationDataWriter {
    private final File rightJsonFileName;
    private final File wrongJsonFileName;

    public JsonFileWriterWithAnatation(final String rightJsonFileName, final String wrongJsonFileName) {
        this.rightJsonFileName = new File(rightJsonFileName);
        this.wrongJsonFileName = new File(wrongJsonFileName);
    }

    public File getRightJsonFileName() {
        return rightJsonFileName;
    }

    public File getWrongJsonFileName() {
        return wrongJsonFileName;
    }

    @Override
    public <T> T dataWrite(List<Transport> rightTransportList, Comparator<Transport> comparator, final Class<T> clazz) throws NoSuchMethodException {
        try {

            for (Transport transport : rightTransportList) {
                final T result = clazz.getDeclaredConstructor().newInstance();
                for (final Field field : clazz.getDeclaredFields()) {
                    for (final Annotation annotation : field.getDeclaredAnnotations()) {
                        if (!(annotation instanceof final Parametr parametr)) {
                            continue;
                        }
                        Object value = clazz.getName();

                        field.setAccessible(true);
                        if (value != null) {
                            if (field.getType().isEnum()) {
                                Class clazzEnum = field.getType();
                                value = Enum.valueOf(clazzEnum, value.toString().toUpperCase());
                            }
                            field.set(result, value);
                        }
                    }
                }
                System.out.println(result);
                return (T) result;
            }
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
