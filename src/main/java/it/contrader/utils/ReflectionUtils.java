package it.contrader.utils;

import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.ParameterizedType;

public class ReflectionUtils {

	public static Class<?> getClassDeclaredInSuperClassGeneric(Object extendedObjWithDeclaredGenerics, int genericPos)
			throws GenericSignatureFormatError, TypeNotPresentException, MalformedParameterizedTypeException,
			MalformedParameterizedTypeException {
		ParameterizedType parameterizedType = (ParameterizedType) extendedObjWithDeclaredGenerics.getClass()
				.getGenericSuperclass();
		return (Class<?>) parameterizedType.getActualTypeArguments()[genericPos];
	}
}
