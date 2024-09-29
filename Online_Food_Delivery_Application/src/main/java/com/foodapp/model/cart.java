package com.foodapp.model;
//<form action="checkout.jsp">
//<input type="hidden" name="quantity" value=<%=cit.getQuantity()%>>
//<input type="hidden" name="subTotal" value=<%=cit.getSubTotal() %>>
//<input type="submit" value="Proceed To Checkout">
//</form>
import java.util.HashMap;
import java.util.Map;

//<%cart c=(cart)session.getAttribute("cart");
//if(c!=null){
//	int total=0;
//for(cartItem cit:c.getAllItems().values()){
//double subTotal=cit.getQuantity()*cit.getPrice();
//total+=subTotal;
public class cart 
{
//	<div class="Cart-Item">
//    <h3>Item ID: <%= cartitem.getItemId() %></h3>
//    <h3>Item Name: <%= cartitem.getName() %></h3>
//    <h3>Price: <%= cartitem.getPrice() %></h3>
//    
//     <form action="cart">
//     <input type="hidden" name="itemId" value="<%= cartitem.getItemId() %>">
//       Quantity: <input type="number" name="quantity" value="<%= cartitem.getQuantity() %>" min="1">
//		  <input type="submit" name="action" value="update">
//		<input type="submit" name="action" value="remove">
//    </form>
//    <h3>Subtotal: <%= cartitem.getSubTotal() %></h3><br>
//   
//</div>
//	 <a href="menu.jsp">Add more items</a>
//     <%
//                 }%>
//                 <form action="checkout.jsp">
//                  <center><input type="submit" value="Proceed To Pay"></center>
//                  </form>
	private HashMap<Integer,cartItem>items;
	public cart() {
		this.items=new HashMap<>();
	}
	public Map addItems(cartItem item) {
		int itemId=item.getItemId();
		if(items.containsKey(itemId)) {
			cartItem existingItem=items.get(itemId);
			existingItem.setQuantity(existingItem.getQuantity()+item.getQuantity());

		}
		else {
			items.put(itemId,item);
		}
		return items;
	}
	
//	public Map updateItems(int itemId,int quantity) {
//		if(items.containsKey(itemId)) {
//			if(quantity<=0) {
//				items.remove(itemId);
//			}
//			else {
//				items.get(itemId).setQuantity(quantity);
//			}
//		}
//		return items;
//		
//	}
	public void updateItems(int itemId,int quantity) {
		if(items.containsKey(itemId)) {
			if(quantity<=0) {
				items.remove(itemId);
			}
			else {
				items.get(itemId).setQuantity(quantity);
			}
		}	
	}
	
	public Map<Integer,cartItem> getAllItems(){
		return items;
	}
	
	public void removeItem(int itemId) {
		items.remove(itemId);
		 
	}
	public void clearItems() {
		items.clear();
		
	}
	public void calculateSubTotal(int itemId) {
        cartItem item = items.get(itemId);
        if (item != null) {
            item.setSubTotal(item.getPrice() * item.getQuantity());
        }
	}
}
