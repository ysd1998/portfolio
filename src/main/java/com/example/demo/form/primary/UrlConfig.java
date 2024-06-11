package com.example.demo.form.primary;

public class UrlConfig {
	public static final String login = "/login";

	public static final String menu = "/menu";

	public static final String bookdata = "/bookdata";

	public static final String webjars = "/webjars/**";
	public static final String commenu = "/common/menu";

	public static final String[] NO_AUTHENTICATION = { login, webjars, commenu, menu, bookdata };

	public static final String[] USER_AUTHENTICATION = { commenu, menu, bookdata };

	public static final String managerlogin = "/manager/login";

	public static final String managermenu = "/manager/menu";

	public static final String managerbookdata = "/manager/bookdata";

	public static final String managerwebjars = "/manager/webjars/**";
	public static final String managercommenu = "/manager/common/menu";

	public static final String[] MN_NO_AUTHENTICATION = { managerlogin, managerwebjars, managercommenu };

}
