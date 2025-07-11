<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="../init.jsp" %>

<portlet:actionURL name='/tag/edit' var="tagEditURL" />

<div class="m-4">
	<h4>Edit tag</h4>
	
<aui:form action="${tagEditURL}" method="post">
	<aui:input name="tagId" value="${tag.tagId}" type="hidden" />
    <aui:input name="tagName" value="${tag.tagName}" label="Tag Name" type="text" required="true" />

    <aui:button type="submit" value="Edit Tag" />
</aui:form>
</div>

