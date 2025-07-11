<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="../init.jsp" %>

<portlet:actionURL name='/tag/create' var="tagCreateURL" />

<div class="m-4">
	<h4>Add new tag</h4>
	
<aui:form action="${tagCreateURL}" method="post">
    <aui:input name="tagName" label="Tag Name" type="text" required="true" />

    <aui:button type="submit" value="Add Tag" />
</aui:form>
</div>

