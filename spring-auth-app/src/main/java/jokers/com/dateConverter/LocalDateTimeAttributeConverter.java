package jokers.com.dateConverter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<Timestamp, LocalDateTime>{

	@Override
	public LocalDateTime convertToDatabaseColumn(Timestamp sqlTimestamp) {
		return (sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime());
	}

	@Override
	public Timestamp convertToEntityAttribute(LocalDateTime locDateTime) {
		return ( locDateTime == null ? null : Timestamp.valueOf(locDateTime));
	}
	
}

