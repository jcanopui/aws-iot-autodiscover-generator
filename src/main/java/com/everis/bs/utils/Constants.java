package com.everis.bs.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Constants {

	public static final List<String> LISTEVENTTYPE = Collections.unmodifiableList(Arrays.asList("AUD", "APP","ERROR","FUN"));
	public static final List<String> LISTEVENTCODE = Collections.unmodifiableList(
			Arrays.asList("AUDIT-MICROSERVICE-RESPONSE_RECEIVED", "AUDIT-MICROSERVICE-END_OK", "AUDIT-MICROSERVICE-START", "AUDIT-MICROSERVICE-REQUEST_SENT", 
					"AUDIT-SERVICE_START", "AUDIT-SERVICE_REQUEST_SENT", "AUDIT-SERVICE_END_OK", "AUDIT-SERVICE_RESPONSE_RECEIVED", "AUDIT-SERVICE_ERROR", 
					"AUDIT-FRONT-SEND_REQUEST ", "AUDIT-FRONT-RESPONSE_RECEIVED", "AUDIT-FRONT-ERROR", "AUDIT-MICROSERVICE-SOA-REQUEST_SENT", "APPLICATION ", 
					"AUDIT-MICROSERVICE-SOA-RESPONSE_ERROR", "AUDIT-MICROSERVICE-ERROR", "AUDIT-FRONT-END_OK", "AUDIT-FRONT-START", 
					"AUDIT-MICROSERVICE-SOA-RESPONSE_RECEIVED"));
	
	public static final List<String> SOURCEAPPLICATION = Collections.unmodifiableList(
			Arrays.asList("web tfem", "WEB BRANCH", "application", "ARQ_auth_reference_app", "BST_FINANCIALTERMINAL", "IBK_CRM", "ARQ_APP", "CUS_ONBOARDING", 
					"webapp", "credentialsPublic", "SoapUI", "TF", "mobapp", "web web", "AST_LOANS", "WEB IBK", "web 3RD", "ServiceChannel ServiceProcedence",
					"AST_COLLATERALS", "BST_LSPA", "BST_SCENARIOS", "web IB01", "aES AES", "WEB tfem", "1 tfem", "web BRH", "ab7112", "FRA_ACTIMIZE", 
					"holdingList", "ApplicationId", "statements", "MD16_CMS", "tt tt", "IBK_CREDITCARDSONBOARD", "P4", "alerts", "IBK_CURRENTACCOUNTSONBOARD", 
					"BST_CSP", "atm atmid", "sSS", "channel tfem", "null null", "web tfem", "web PoC", "web TFEM", "ASS_PAPYRUS", "N/A", "PoC PoC", 
					"savingAccounts", "Prdir4"));
	
	public static final int LIMIT_TEXT_DETAIL = 200;
}
