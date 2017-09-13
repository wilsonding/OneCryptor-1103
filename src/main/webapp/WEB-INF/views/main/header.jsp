
<header class="navbar navbar-expand-sm bg-dark navbar-dark ">
	<div class="container">
		<a href="${pageContext.request.contextPath}/home" class="navbar-brand">
			<img alt="logo" src="/images/oc_sm.png">OneCryptor</a>
		<button class="navbar-toggler" data-toggle="collapse"
			data-target="#navbarCollapse">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/home" class="nav-link">Home</a>
				</li>
				<li class="nav-item"><a href="${pageContext.request.contextPath}/download" class="nav-link">Download</a>
				</li>
				<li class="nav-item"><a href="${pageContext.request.contextPath}/pricing" class="nav-link">Pricing</a>
				</li>
				<li class="nav-item"><a href="${pageContext.request.contextPath}/product" class="nav-link">Product</a>
				</li>
				<li class="nav-item"><a href="${pageContext.request.contextPath}/customer" class="nav-link">Customer</a>
				</li>
				<li class="nav-item"><a href="${pageContext.request.contextPath}/blog" class="nav-link">Blog</a>
				</li>
			</ul>
		</div>
		<a href="${pageContext.request.contextPath}/login">
		<button type="button" class="btn btn-outline-success btn-sm">Sign In</button>
		</a>
	</div>
</header>
