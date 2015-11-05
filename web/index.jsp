
<!--Copyright Jack Landry and Lexa Grasz 2015-->


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/includes/header.html" %>
<body>
  <h1>Future Value Calculator</h1>
    

    
    <form class="form" action="calculate" method="post">
      <input type="hidden" name="action" value="add">        
      <label>Investment Amount</label>
      <input type="number" min="0" name="investment" value="${user.investment}" required><br>
      <label>Yearly Interest Rate</label>
      <input  type="number" min="0" name="interest" value="${user.interest}" required><br>
      <label>Number of Years</label>
      <input  type="number"  min="0" name="years" required
               placeholder="Integer number of years." ><br>
      <label class="spacer">&nbsp;</label>
      <input type="submit" value="Calculate" class="button">
    </form>



<%@ include file="/includes/footer.jsp" %>
 