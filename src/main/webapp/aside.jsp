<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>
				<!-- 其中authentication代表的是当前认证对象，可以获取当前认证对象信息，例如用户名 -->
				<!-- property： 只允许指定Authentication所拥有的属性，可以进行属性的级联获取，如“principal.username”，
					不允许直接通过方法进行调用
					htmlEscape：表示是否需要将html进行转义。默认为true。
					scope：与var属性一起使用，用于指定存放获取的结果的属性名的作用范围，默认我pageContext。Jsp中拥
					有的作用范围都进行进行指定
					var： 用于指定一个属性名，这样当获取到了authentication的相关信息后会将其以var指定的属性名进行存
					放，默认是存放在pageConext中 -->
				<security:authentication property="principal.username"/></p>
				<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
				href="${pageContext.request.contextPath}/main.jsp"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>

			<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
					<span>系统管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>


			</a>
				<ul class="treeview-menu">
				
				<!--  authorize是用来判断普通权限的，通过判断用户是否具有对应的权限而控制其所包含内容的显示-->
				<!--  property： 只允许指定Authentication所拥有的属性，可以进行属性的级联获取，如“principal.username”，
不允许直接通过方法进行调用
htmlEscape：表示是否需要将html进行转义。默认为true。
scope：与var属性一起使用，用于指定存放获取的结果的属性名的作用范围，默认我pageContext。Jsp中拥
有的作用范围都进行进行指定
var： 用于指定一个属性名，这样当获取到了authentication的相关信息后会将其以var指定的属性名进行存
放，默认是存放在pageConext中-->
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<li id="system-setting">
					
					<a
						href="${pageContext.request.contextPath}/user/findAll.do?page=1&&size=3"> <i
							class="fa fa-circle-o"></i> 用户管理
					</a></li>
					</security:authorize>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/role/findAll.do?page=1&&size=3"> <i
							class="fa fa-circle-o"></i> 角色管理
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/permission/findAll.do?page=1&&size=3">
							<i class="fa fa-circle-o"></i> 资源权限管理
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/sysLog/findAll.do?page=1&&size=3"> <i
							class="fa fa-circle-o"></i> 访问日志
					</a></li>
				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>基础数据</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/product/findAll.do?page=1&&size=3">
							<i class="fa fa-circle-o"></i> 产品管理
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/orders/findAll.do?page=1&size=3"> <i
							class="fa fa-circle-o"></i> 订单管理
					</a></li>

				</ul></li>

		</ul>
	</section>
	<!-- /.sidebar -->
</aside>