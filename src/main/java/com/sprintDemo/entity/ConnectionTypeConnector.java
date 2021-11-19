package com.sprintDemo.entity;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ConnectionTypeConnector implements AttributeConverter<ConnectionType, Integer> 
{
		@Override
		public Integer convertToDatabaseColumn(ConnectionType attribute) {
			// TODO Auto-generated method stub
			if(attribute == null ) {
				return null;
			}
			return attribute.getType();
		}

		@Override
		public ConnectionType convertToEntityAttribute(Integer dbData) {
			// TODO Auto-generated method stub
			if(dbData == null) {
				return null;
			}
			for(ConnectionType conType : ConnectionType.values()) {
				if(conType.getType() == dbData) {
					return conType;
				}
			}
			return null;
			//return Stream.of(ConnectionType.values()).filter(c-> c.getType() == dbData).findFirst().orElseThrow();
		}

	}



