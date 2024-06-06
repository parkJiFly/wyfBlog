package com.soft.park.enums;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/6/6 15:57
 * @description
 */
public class ConstEnum {

	/**
	 * redis配置
	 */
	public enum REDIS {
		/**
		 * 项目
		 */
		KEY_PREFIX("wyf", "项目"),
		/**
		 * key分隔符
		 */
		KEY_SPLIT_CHAR(":", "key分隔符"),


		;
		public final String code;
		public final String label;

		REDIS(String code, String label) {
			this.code = code;
			this.label = label;
		}
	}

}
