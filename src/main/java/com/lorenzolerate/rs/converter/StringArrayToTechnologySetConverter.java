package com.lorenzolerate.rs.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;

import com.lorenzolerate.rs.model.Technology;

public class StringArrayToTechnologySetConverter implements Converter<String[], Set<Technology>> {

	@Override
	public Set<Technology> convert(String[] source) {
		Set<Technology> result = new HashSet<>();
		for (int i = 0; i < source.length; i++) {
			Technology technology = new Technology();
			technology.setName(source[i]);
			result.add(technology);
		}
		return result;
	}

}
