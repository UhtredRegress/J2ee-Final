<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ include file="/init.jsp" %>

<liferay-portlet:renderURL var="tagIndexURL">
    <portlet:param name="mvcRenderCommandName" value="/tag/index" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="documentIndexURL">
    <portlet:param name="mvcRenderCommandName" value="/document/index"/>
</liferay-portlet:renderURL>


<div class="gap-2 m-4">
    <a href="${documentIndexURL }" class="btn btn-primary">Document</a>
    <a href="${tagIndexURL}" class="btn btn-success">Tag</a>
</div>