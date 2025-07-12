<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="../init.jsp" %>

<portlet:actionURL name='/document/create' var="documentCreateURL" />

<div class="m-4">
	<aui:form action="${documentCreateURL}" method="post" enctype="multipart/form-data">
    <aui:input name="title" label="Title" type="text" required="true" />
    <aui:input name="author" label="Author" type="text" required="true" />
    <aui:input name="yearPublished" label="Year Published" type="number" required="true" />

     <aui:select name="tagId" label="Select Tag" required="true">
        <aui:option value="" label="-- Select Tag --" />
        <c:forEach var="tag" items="${tagList}">
            <aui:option value="${tag.tagId}" label="${tag.tagName}" />
        </c:forEach>
    </aui:select>

    <aui:input name="documentFile" label="Upload File" type="file" required="true" />

    <aui:button type="submit" value="Add Document" />
</aui:form>
</div>

