<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="../init.jsp" %>
<%@ page import="com.document.data.viewmodel.DocumentIndexViewModel" %>
<liferay-portlet:renderURL var="documentCreateURL">
    <portlet:param name="mvcRenderCommandName" value="/document/create" />
</liferay-portlet:renderURL>
<div class="m-4">
	<a href="${documentCreateURL}" class="btn btn-primary mb-2">Add new Document</a>
	<liferay-ui:search-container
	    total="${totalCount}"
	    delta="5"
	    emptyResultsMessage="No documents found"
	    iteratorURL="${iteratorURL}">
	
	    <liferay-ui:search-container-results results="${documentList}" />
	
	    <liferay-ui:search-container-row
	        className="com.document.data.viewmodel.DocumentIndexViewModel"
	        modelVar="document">
	
	        <liferay-ui:search-container-column-text
	            name="Title"
	            value="${document.title}" />
	
	        <liferay-ui:search-container-column-text
	            name="Tag"
	            value="${document.tagName}" />
	
	        <liferay-ui:search-container-column-text
	            name="Author"
	            value="${document.author}" />
	
	        <liferay-ui:search-container-column-text
	            name="Year"
	            value="${document.yearPublished}" />
	
	        <liferay-ui:search-container-column-text name="Actions">
				<div class="d-flex align-items-center gap-2">
					<portlet:renderURL var="documentEditURL">
						<portlet:param name="mvcRenderCommandName" value="/document/edit" />
						<portlet:param name="documentId" value="${document.documentId}" />
					</portlet:renderURL>
					<portlet:actionURL var="deleteDocumentURL" name="/document/delete">
						<portlet:param name="documentId" value="${document.documentId}" />
					</portlet:actionURL>
					
						
					<a href="${documentEditURL}" class="btn btn-sm btn-warning" style="margin-right:0.25rem">Edit</a>
				
					<aui:form method="post" action="${deleteDocumentURL}" onSubmit="return confirm('Are you sure to delete?')" cssClass="m-0 p-0">
						
						
						<!-- Wrap the button in a div to ensure spacing works -->
						<div class="d-inline">
							<aui:button type="submit" value="Delete" cssClass="btn btn-sm btn-danger" />
						</div>
					</aui:form>
				</div>
	        </liferay-ui:search-container-column-text>
	    </liferay-ui:search-container-row>
	
	    <liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>