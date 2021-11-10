Feature: My Store Add Two Items

Scenario Outline: My Store Add Two Items

Given user is already on Landing Page
When title of landing page is My Store
Then user clicks on sign in button
When title of login page is My Store Login
Then user enters "<username>" and "<password>"
Then user clicks on login button
Then user is on home page
Then user clicks on WOMEN button
When title of women page is Women My Store
Then user clicks on faded tshirt button
Then user clicks on add to cart
Then user clicks on continue shopping
Then user clicks on printed dress
Then user clicks on more button
When title of printed dress page is Printed Chiffon Dress My Store
Then user clicks on add to cart button
Then user clicks on proceed to checkout button
When title of order page is Order My Store
Then user clicks on proceed to checkout button on order page
When title of address page is Order My Store
Then user clicks on proceed to checkout button on address page
When title of shipping page is Order My Store
Then user clicks on check box
Then user clicks on proceed to checkout button on shipping page
When title of payment page is Order My Store
Then user clicks on pay by check button
When title of order summary page is My Store
Then user clicks on confirm button
When title of order confirmation page is Order confirmation My Store
Then user clicks on back button
When title of order history page is Order history My Store
Then user clicks on pdf button
Then Close the browser

Examples:
	| username             | password |
	| is4102@ucsctest.com  | test@123 |