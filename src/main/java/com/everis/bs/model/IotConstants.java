package com.everis.bs.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IotConstants {

	public static final List<String> LISTTHINGTYPE = Collections.unmodifiableList(Arrays.asList("SENSOR", "LIGHT"));

	public static final List<String> LISTTHINGREGION = Collections.unmodifiableList(Arrays.asList("TOP", "BOTTOM","LEFT", "RIGHT"));

	public static final List<String> LISTTHINGCOLOR = Collections.unmodifiableList(Arrays.asList("RED", "BLUE","YELLOW", "WHITE", "BLACK", "GREEN"));
}
