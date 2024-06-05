package com.soft.park.enums;

import java.util.Objects;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/6/5 15:41
 * @description
 */
public interface BaseEnum {

	/**
	 * 获取枚举类的值
	 *
	 * @return Object
	 */
	Object getValue();

	/**
	 * 获取枚举类的说明
	 *
	 * @return String
	 */
	String getDesc();

	/**
	 * 比较参数是否与枚举类的value相同
	 *
	 * @param value
	 * @return boolean
	 */
	default boolean equalsValue(Object value) {
		return Objects.equals(getValue(), value);
	}

	/**
	 * 比较枚举类是否相同
	 *
	 * @param baseEnum
	 * @return boolean
	 */
	default boolean equals(BaseEnum baseEnum) {
		return Objects.equals(getValue(), baseEnum.getValue()) && Objects.equals(getDesc(), baseEnum.getDesc());
	}

	/**
	 * 返回枚举类的说明
	 *
	 * @param clazz 枚举类类对象
	 * @return
	 */
	static String getInfo(Class<? extends BaseEnum> clazz) {
		BaseEnum[] enums = clazz.getEnumConstants();

		StringBuilder sb = new StringBuilder("");
		for (BaseEnum e : enums) {
			sb.append(e.getValue() + e.getDesc() + ",");
		}
		String info = sb.toString();
		info = info.length() > 0 ? info.substring(0, info.length() - 1) : "";
		return info;

		//        BaseEnum[] enums = clazz.getEnumConstants();
		//        LinkedHashMap<String, JSONObject> json = new LinkedHashMap<>(enums.length);
		//        for (BaseEnum e : enums) {
		//            JSONObject jsonObject = new JSONObject();
		//            jsonObject.put("value", new DeletedQuotationAware(e.getValue()));
		//            jsonObject.put("desc", new DeletedQuotationAware(e.getDesc()));
		//            json.put(e.toString(), jsonObject);
		//        }
		//
		//        String enumJson = JSON.toJSONString(json, true);
		//        enumJson = enumJson.replaceAll("\"", "");
		//        enumJson= enumJson.replaceAll("\t","&nbsp;&nbsp;");
		//        enumJson = enumJson.replaceAll("\n","<br>");
		//        String prefix = "  <br>  export const <br> " + CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, clazz.getSimpleName() + " = <br> ");
		//        return prefix + "" + enumJson + " <br>";

	}


}
