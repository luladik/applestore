<table>
    <tr>
        <th>Product name</th>
        <th>Price</th>

    </tr>
<#list products as product>
    <tr>
        <td>${product.name}</td>
        <td>$${product.price}</td>
    <#--<td><img src="${product.imagePath}" style="max-width: 500px; height: 200px; border: 3px solid #73AD21"/></td>-->
    </tr>
</#list>
</table>