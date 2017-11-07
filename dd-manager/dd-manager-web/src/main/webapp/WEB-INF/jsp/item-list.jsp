<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="easyui-datagrid">
    <thead>
    <tr>
        <th data-options="field:'code'">编码</th>
        <th data-options="field:'name'">名称</th>
        <th data-options="field:'price'">价格</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="tbitem">
        <tr>
            <td>${tbitem.id}</td>
            <td>${tbitem.title}</td>
            <td>${tbitem.price}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

商品列表页面
