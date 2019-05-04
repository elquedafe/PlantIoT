package es.upm.dte.iot.hwplatform;

import java.util.Map;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import es.upm.dte.iot.infomodel.*;

public class LCDDescriptionJSONParser implements IActuationDescriptionParser {

	@Override
	public Object parseActuationDescription(Object toBeParsed) {
		LCDActionDescription desc=null;
		if ( !(toBeParsed instanceof JsonObject))
			throw new IllegalArgumentException("LCD Description is not JSON.");
		JsonObject object = (JsonObject) toBeParsed;
		Set<Map.Entry<String,JsonElement>> objectMembers = object.entrySet();
		if ( objectMembers.size() != 2)
			throw new IllegalStateException("LCD description has not only 2 members.");
		String l1 = null, l2 = null;
		for( Map.Entry<String, JsonElement> member : objectMembers ) {
			String key = member.getKey();
			if ( key.equalsIgnoreCase("l1")) {
				l1 = member.getValue().getAsString();
			}
			if ( key.equalsIgnoreCase("l2")) {
				l2 = member.getValue().getAsString();
			}
		}
		
		if ( l1 == null || l2 == null )
			throw new IllegalStateException("Miissing l1 or l2 in actuation description.");
		desc = new LCDActionDescription(l1, l2);
		return desc;
	}
}