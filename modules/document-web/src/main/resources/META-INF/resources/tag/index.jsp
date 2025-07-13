<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="../init.jsp" %>

<liferay-portlet:renderURL var="tagCreateURL">
    <portlet:param name="mvcRenderCommandName" value="/tag/create" />
</liferay-portlet:renderURL>

<div class="m-4">
	<a href="${tagCreateURL}" class="btn btn-primary">Add new tag</a>
	<c:if test="${not empty tagList}">
    <table class="table table-bordered mt-3">
        <thead>
            <tr>
                <th>Tag Name</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="tag" items="${tagList}" varStatus="loop">
                <tr>
					<portlet:renderURL var="editTagURL">
						<portlet:param name="mvcRenderCommandName" value="/tag/edit" />
						<portlet:param name="tagId" value="${tag.tagId}" />
					</portlet:renderURL>

					<portlet:actionURL var="deleteTagURL" name="/tag/delete">
						<portlet:param name="tagId" value="${tag.tagId}" />
					</portlet:actionURL>

					<td>${tag.tagName}</td>
					<td class="text-nowrap">
						<div class="d-inline-block me-2">
							<a href="${editTagURL}" class="btn btn-sm btn-warning">Edit</a>
						</div>
						<div class="d-inline-block">
							<form method="post" action="${deleteTagURL}" class="d-inline"
      onsubmit="return confirm('Are you sure you want to delete this tag?')">
    							<button type="submit" class="btn btn-sm btn-danger">Delete</button>
							</form>
						</div>
					</td>
				</tr>

            </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${empty tagList}">
    <div class="alert alert-info mt-3">No tags available.</div>
</c:if>	
</div>

