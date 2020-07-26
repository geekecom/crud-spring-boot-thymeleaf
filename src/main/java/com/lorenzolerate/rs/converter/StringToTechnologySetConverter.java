package com.lorenzolerate.rs.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;

import com.lorenzolerate.rs.model.Technology;

/**
 * This class is called when only one technology has been selected
 * 
 * @author Lorenzo Lerate
 *
 */
public class StringToTechnologySetConverter implements Converter<String, Set<Technology>> {

	@Override
	public Set<Technology> convert(String source) {
		Set<Technology> result = new HashSet<>();
		Technology technology = new Technology();
		technology.setName(source);
		result.add(technology);
		return result;
	}

}
