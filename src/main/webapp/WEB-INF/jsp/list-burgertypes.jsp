<%@ include file="common/header.jspf"%>

<div class="container">
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>Bestel een burger</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="40%">Opties</th>
						<th width="60%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${burgerTypes}" var="burger">
						<tr>
							<td>${burger}</td>
							<td><a type="button" class="btn btn-success"
								href="/add-burger?name=${burger}">Bestel</a>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
<%@ include file="common/footer.jspf"%>