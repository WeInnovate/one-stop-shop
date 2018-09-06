<%@ page import="com.onestopshop.model.Item"%>
<jsp:useBean id="item" class="com.onestopshop.model.Item" />
<jsp:setProperty property="*" name="item" />
<%
	request.setAttribute("item", item);
%>
<jsp:forward page="items" />