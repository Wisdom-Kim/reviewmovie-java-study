<form action="${pageContext.request.contextPath}/movies.do" method="get">
    <input type="text" name="searchTitle" placeholder="Enter movie title" />
    <input type="submit" value="Search" />
</form>

<div class="movie-list">
    <c:if test="${not empty movieList}">
        <c:forEach items="${movieList}" var="movie" step="3">
            <div class="row">
                <c:forEach items="${movieList}" var="item" begin="${status.index}" end="${status.index + 2}" varStatus="status">
                    <div class="movie-item">
                        <a href="${pageContext.request.contextPath}/detailPage.do?movieId=${item.id}">
                            <img src="${item.poster}" alt="${item.title}" class="movie-poster">
                            <h3>${item.title}</h3>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </c:forEach>
    </c:if>
    
    <c:if test="${empty movieList}">
        <p>No search results found.</p>
    </c:if>
</div>