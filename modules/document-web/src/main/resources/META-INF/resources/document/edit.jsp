<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="../init.jsp" %>

<portlet:actionURL name='/document/edit' var="documentEditURL" />

<div class="m-4">
	<aui:form action="${documentEditURL}" method="post" enctype="multipart/form-data">
    <aui:input name="documentId" type="hidden" value ="${document.documentId}"/>
    <aui:input name="title" label="Title" value="${document.title }"  type="text" required="true" />
    <aui:input name="author" label="Author" value="${document.author }" type="text" required="true" />
    <aui:input name="yearPublished" label="Year Published" value="${document.yearPublished }" type="number" required="true" />

     <aui:select name="tagId" label="Select Tag" required="true" value="${document.tagId }"> 
        <aui:option value="" label="-- Select Tag --" />
        <c:forEach var="tag" items="${tagList}">
            <aui:option value="${tag.tagId}" label="${tag.tagName}" />
        </c:forEach>
    </aui:select>

    <aui:input name="documentFile" label="Upload File" type="file" required="false" />

    <aui:button type="submit" value="Add Document" />
</aui:form>
</div>

