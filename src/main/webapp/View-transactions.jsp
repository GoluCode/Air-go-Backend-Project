<%@ page import="java.util.List" %>
<%@ page import="go.base.Transactions" %>
...
<%
    List<Transactions> transactions = (List<Transactions>) request.getAttribute("transactions");

    if (transactions == null || transactions.isEmpty()) {
%>
        <p>No transactions found.</p>
<%
    } else {
%>
    <table>
        <thead>
            <tr>
                
                <th>Flight No></th>
                <th>Current status</th>
                <th>Transection No</th>
            </tr>
        </thead>
        <tbody>
        <%
            for (Transactions entry : transactions) {
        %>
            <tr>
                <td><%= entry.getFlightNo() %></td>
                <td><%= entry.getStatus() %></td>
                <td><%= entry.getTransectionNo() %></td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
<%
    }
%>
