<#import "utils/main.ftl" as c>
<@c.page>
    <table class="table table-responsive-md mt-5">
        <thead>
        <tr>
            <th scope="col">Имя</th>
            <th scope="col">Фамилия</th>
        </tr>
        </thead>
        <tbody>
        <#list authors as author>
            <tr>
                <td>${author.name}</td>
                <td>${author.surname}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>