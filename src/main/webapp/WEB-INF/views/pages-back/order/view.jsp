<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/views/include/common_meta.jspf" %>
        <title><spring:message code="page.header"></spring:message></title>
        <%@include file="/WEB-INF/views/include/common_cssbackend.jspf"%>
    </head>
    <body>
        <%@include file="/WEB-INF/views/pages-back/include/common_header.jspf"%>
        <div class="container">
            <form:form id="approveForm" name="approveForm" modelAttribute="approveForm" servletRelativeAction="/backend/order/save" method="POST">
                <input type="hidden" id="orderId" name="orderReport.orderId" value="${approveForm.orderReport.orderId}" />
                <input type="hidden" id="splitItems" name="splitItems" value=""/>
                <!-- Header -->
                <div class="row bg_color">
                    <div class="col-sm-6 bg_color">
                        <h1 id="order-code">${approveForm.orderReport.orderCode}</h1>
                    </div>
                    <div class="col-sm-6 text-right bg_color">
                        <h1>${approveForm.orderReport.orderStatus}</h1>
                    </div>
                    <!-- Button -->
                    <div class="col-sm-12 bg_color" style="margin-top: 10px;">
                        <div class="col-sm-6" style="padding: 20px 0px 10px 0px;">
                            <div id="btn-save" class="btn btn-primary">Save</div>
                        </div>
                        <div class="col-sm-6 text-right" style="padding: 20px 0px 10px 0px;">
                            <div id="btn-approve" class="btn btn-success">Approve</div>
                            <div id="btn-reject" class="btn btn-danger">Reject</div>
                        </div>
                    </div>
                    <!-- Order info -->
                    <div class="col-sm-12 bg_color">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Order Date</th>
                                    <th>Expected Shipping Date</th>
                                    <th>Payment Term</th>
                                    <th>Payment Method</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <fmt:formatDate pattern="dd-MM-yyyy" value="${approveForm.orderReport.orderDate}" />
                                    </td>
                                    <td>
                                        <fmt:formatDate pattern="dd-MM-yyyy" value="${approveForm.orderReport.expectShipmentDate}" />
                                    </td>
                                    <td>
                                        <form:select path="orderReport.paymentTermId" cssClass="form-control editable">
                                            <form:options items="${approveForm.paymentTermList}" itemLabel="paymentTermName" itemValue="paymentTermId" />
                                        </form:select>
                                    </td>
                                    <td colspan="2">
                                        <form:select path="orderReport.paymentMethod" cssClass="form-control editable">
                                            <form:options items="${approveForm.paymentMethodList}" itemLabel="paymentMethodName" itemValue="paymentMethodId" />
                                        </form:select>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <!-- Order Address detail -->
                    <div class="col-sm-6 bg_color">
                        <div class="col-sm-12">Dispatch to:</div>
                        <div class="col-sm-12">${approveForm.orderReport.dispatchToAddress.orderAddr}</div>
                        <div class="col-sm-12">Tel: ${approveForm.orderReport.dispatchToAddress.orderTel} Fax: ${approveForm.orderReport.dispatchToAddress.fax}</div>
                    </div>
                    <div class="col-sm-6 bg_color">
                        <div class="col-sm-12">Invoice to:</div>
                        <div class="col-sm-12">${approveForm.orderReport.invoiceToAddress.orderAddr}</div>
                        <div class="col-sm-12">Tel: ${approveForm.orderReport.invoiceToAddress.orderTel} Fax: ${approveForm.orderReport.invoiceToAddress.fax}</div>
                    </div>
                    <!-- Order detail -->
                    <div class="col-sm-12 bg_color">
                        <table class="table table-hover table-list">
                            <thead>
                                <tr>
                                    <th>No</th>
                                    <th>Product Code</th>
                                    <th>Description</th>
                                    <th>Price</th>
                                    <th>Qty</th>
                                    <th>Shipped</th>
                                    <th>Pending</th>
                                    <th>UOM</th>
                                    <th>Unit Price</th>
                                    <th>Amount</th>
                                    <th>Remove</th>
                                    <th>Split</th>
                                </tr>
                            </thead>
                            <tbody id="item-list"></tbody>
                        </table>
                    </div>
                    <!-- Customer remark -->
                    <div class="col-sm-6 bg_color" style="padding-bottom: 10px;">
                        <div class="">Customer Remark</div>
                        <div class="">
                            <textarea class="form-control" rows="5" cols="50">${approveForm.orderReport.remarkCustomer}</textarea>
                        </div>
                    </div>
                    <div class="col-sm-6 bg_color">
                        <div class="">Shipping Type</div>
                        <div class="" style="padding-bottom: 10px;">
                            <textarea class="form-control" rows="5" cols="50">${approveForm.orderReport.shippingType}</textarea>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
        <!--
        -- DIALOG TEMPLATE
        -->
        <div id="split-init" class="modal fade" role="dialog" data-backdrop="static">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <h3>Specify number of line</h3>
                    </div>
                    <div class="modal-body">
                        <form>
                            <input type="text" name="row" class="form-control"/>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <div class="text-right" style="padding: 0px;">
                            <button type="button" class="btn btn-primary" name="split">Split</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="split-detail" class="modal fade" role="dialog" data-backdrop="static">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h3>Adjust item amount</h3>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-sm-12">
                                <table class="table table-hover table-list">
                                    <thead>
                                        <tr>
                                            <th>No</th>
                                            <th>Product Code</th>
                                            <th>Description</th>
                                            <th>Price</th>
                                            <th>Qty</th>
                                            <th>UOM</th>
                                            <th>Unit Price</th>
                                            <th>Amount</th>
                                        </tr>
                                    </thead>
                                    <tbody id="split-list"></tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="col-sm-6 text-left" style="padding-left: 0px; padding-right: 0px;">
                            Original amount is <span id="amount-original">0</span> items and current amount is <span id="amount-current">0</span> items.
                        </div>
                        <div class="col-sm-6 text-right" style="padding-left: 0px; padding-right: 0px;">
                            <button type="button" class="btn btn-primary" name="done">Done</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="/WEB-INF/views/include/common_js.jspf"%>
        <%@include file="/WEB-INF/views/include/common_footer.jspf"%>
        <script type="text/javascript" src="<c:url value="/scripts/backend/js/markup.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/scripts/backend/js/accounting.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/scripts/backend/js/notify.min.js"/>"></script>
        <script type="text/html" id="item-template">
            {{Items}}
            {{if HasItem}}
        <tr>
            <td>{{##}}</td>
            <td>{{ProductCode}}</td>
            <td>{{ProductName}}</td>
            <td>
                <select name="product-price-group" class="form-control price-group editable" data-item="{{#}}">
                    <option value="blank"></option>
                    {{PriceGroups}}{{if HasMoreGroup}}<option value="{{PriceGroupID}}">{{PriceGroupName}}</option>{{/if}}{{/PriceGroups}}
                </select>
            </td>
            <td class="text-right">{{Amount|format>0}}</td>
            <td>Shipped</td>
            <td>Pending</td>
            <td>{{ProductUnit}}</td>
            <td class="text-right">{{Price|format>2}}</td>
            <td class="text-right">{{Total|format>2}}</td>
            <td>
                <div class="btn btn-default item-remove" data-item="{{#}}">Remove</div>
            </td>
            <td>
                <div class="btn btn-default item-split" data-item="{{#}}">Split</div>
            </td>
        </tr>
        {{/if}}
        {{/Items}}
    </script>
    <script type="text/html" id="split-template">
        {{Items}}
        {{if HasItem}}
        <tr>
            <td>{{##}}</td>
            <td>{{ProductCode}}</td>
            <td>{{ProductName}}</td>
            <td>
                <select name="product-price-group" class="form-control price-group" data-item="{{#}}">
                    <option value="blank"></option>
                    {{PriceGroups}}{{if HasMoreGroup}}<option value="{{PriceGroupID}}">{{PriceGroupName}}</option>{{/if}}{{/PriceGroups}}
                </select>
            </td>
            <td><input type="text" class="form-control" name="amount" value="{{Amount}}" data-index="{{#}}"/></td>
            <td>{{ProductUnit}}</td>
            <td class="text-right">{{Price|format>2}}</td>
            <td class="text-right">{{Total|format>2}}</td>
        </tr>
        {{/if}}
        {{/Items}}
    </script>

    <script type="text/javascript">
/*
 * data binding
 */
var context = {
    Items: [
        //<c:forEach items="${approveForm.orderReport.orderDetails}" var="item">
        {
            ID: '${item.orderDetailId}',
            ProductID: '${item.productId}',
            ProductCode: '${item.productCode}',
            ProductName: '${item.productName}',
            ProductUnit: '${item.productUnit}',
            ProductCurrency: '${item.productCurrency}',
            Amount: ${item.amount},
            Price: ${item.unitPrice},
            Total: ${item.amount*item.unitPrice},
            BuyerGroupID: '${item.productBuyerGroupId}',
            HasItem: true,
            PriceGroups: [
                //<c:forEach items="${approveForm.productPriceGroupList}" var="group">
                {
                    PriceGroupID: '${group.productPriceGroupId}',
                    PriceGroupName: '${group.productPriceGroupName}',
                    HasMoreGroup: true
                },
                //</c:forEach>
                {}
            ]
        },
        //</c:forEach>
        {}
    ]
};

/*
 * application
 */
var app = {
    editable: ${approveForm.editMode},
    item: {
        template: '',
        render: function () {
            $('#item-list').html(Mark.up(app.item.template, context));
        }
    },
    split: {
        index: 0,
        row: 0,
        context: {
            Items: []
        },
        template: '',
        amount: function () {
            var items = app.split.context.Items;
            var total = 0;
            for (var i = 0; i < items.length; i++) {
                total = total + Number(items[i].Amount);
            }
            return total;
        },
        render: function () {
            $('#amount-current').text(app.split.amount());
            $('#split-list').html(Mark.up(app.split.template, app.split.context));
        }
    },
    init: function () {
        $(document).on('change', '.price-group', function (event) {
            alert('change price group for item id -> ' + $(this).attr('data-item'));
        });
        //
        $(document).on('click', '.item-remove', function (event) {
            if (!app.editable) {
                return;
            }
            var item = $(this).attr('data-item');
            context.Items.splice(item, 1);
            app.item.render();
        });
        //
        $(document).on('click', '.item-split', function (event) {
            if (!app.editable) {
                return;
            }
            app.split.index = $(this).attr('data-item');
            $('#split-init input[name=row]').val(context.Items[app.split.index].Amount);
            $('#split-init').modal('toggle');
        });
        //
        $(document).on('click', '#split-init button[name=split]', function (event) {
            var row = $('#split-init input[name=row]').val();
            if (row <= context.Items[app.split.index].Amount) {
                app.split.row = row;
                $('#split-init').modal('toggle');
            } else {
                $(this).notify('you can not split line more than amount', 'warn');
                app.split.index = 0;
                app.split.row = 0;
            }
        });
        //
        $(document).on('click', '#split-detail button[name=done]', function (event) {
            if (context.Items[app.split.index].Amount === app.split.amount()) {
                context.Items.splice(app.split.index, 1);
                for (var i = 0; i < app.split.context.Items.length; i++) {
                    context.Items.push(app.split.context.Items[i]);
                }
                app.item.render();
                $('#split-detail').modal('toggle');
            } else {
                $(this).notify('total split quantity not equals original quantity', 'warn');
            }

        });
        //
        $(document).on('change', '#split-list input[name=amount]', function (event) {
            var master = context.Items[app.split.index];
            var quantity = $(this).val();
            var index = $(this).attr('data-index');
            var original = master.Amount;
            var current = app.split.context.Items[index].Amount;
            var total = app.split.amount() - current + Number(quantity);
            if (original >= total) {
                app.split.context.Items[index].Amount = quantity;
                app.split.context.Items[index].Total = quantity * master.Price;
                app.split.render();
            } else {
                $(this).notify('total split amount more than original amount', 'warn');
            }
        });
        //
        $(document).on('shown.bs.modal', '#split-detail', function () {
            $('#amount-original').text(context.Items[app.split.index].Amount);
            app.split.render();
        });
        //
        $(document).on('hidden.bs.modal', '#split-init', function () {
            var master = context.Items[app.split.index];
            if (app.split.row > 0) {
                for (var i = 0; i < app.split.row; i++) {
                    app.split.context.Items.push({
                        ID: 0,
                        ProductID: master.ProductID,
                        ProductCode: master.ProductCode,
                        ProductName: master.ProductName,
                        ProductUnit: master.ProductUnit,
                        ProductCurrency: master.ProductCurrency,
                        Amount: 1,
                        Price: master.Price,
                        Total: master.Price,
                        BuyerGroupID: master.BuyerGroupID,
                        HasItem: true,
                        PriceGroups: master.PriceGroups
                    });
                }
                $('#split-detail').modal('toggle');
            }
        });
        //
        $(document).on('hidden.bs.modal', '#split-detail', function () {
            app.split.index = 0;
            app.split.row = 0;
            app.split.context.Items = [];
        });
        //
        $('#btn-save').on('click', function (event) {
            if (!app.editable) {
                return;
            }
            var master = context.Items;
            var data = [];
            for (var i = 0; i < master.length; i++) {
                var obj = master[i];
                data.push({
                    ProductID: obj.ProductID,
                    ProductUnit: obj.ProductUnit,
                    ProductCurrency: obj.ProductCurrency,
                    Amount: obj.Amount,
                    Price: obj.Price,
                    BuyerGroupID: obj.BuyerGroupID
                });
            }
            $('#splitItems').val(JSON.stringify(data));
            $('#approveForm').submit();
        });
        //
        $('#btn-approve').on('click', function (event) {
            if (!app.editable) {
                return;
            }
            alert('approve order id -> ' + $(this).attr('data-id'));
        });
        //
        $('#btn-reject').on('click', function (event) {
            if (!app.editable) {
                return;
            }
            alert('reject order id -> ' + $(this).attr('data-id'));
        });
        //
        Mark.pipes.format = function (num, p) {
            return accounting.formatMoney(num, '', p);
        };
        //
        app.split.template = $('#split-template').html();
        app.item.template = $('#item-template').html();
        app.item.render();
        if (!app.editable) {
            $('select.editable').prop('disabled', true);
        }
    }
};

$(function () {
    app.init();
});
    </script>
</body>
</html>
