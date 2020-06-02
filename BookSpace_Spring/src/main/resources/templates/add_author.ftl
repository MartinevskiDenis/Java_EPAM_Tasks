<#import "utils/main.ftl" as c>
<@c.page>
    <form method="post">
        <div class="form-row mt-3 justify-content-center">
            <div class="form-group col-md-3">
                <label>Имя</label>
                <input type="text" class="form-control" name="name"
                       value="" required>
            </div>
            <div class="form-group col-md-3">
                <label>Фамилия</label>
                <input type="text" class="form-control" name="surname"
                       value="" required>
            </div>
        </div>
        <div class="form-row justify-content-center">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit" style="margin-top: 3%" class="btn btn-primary btn-lg">Добавить</button>
        </div>
    </form>
</@c.page>