package online_shopping;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.List;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.html.HTMLDocument.Iterator;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;

public class Main {

	private JFrame frmOnlineShoppingSystem;
	private JTextField tfEmailID;
	private JPasswordField passwordField;
	private JTextField emailID;
	private JPasswordField passwordField_1;
	private JTextField firstName;
	private JTextField lastName;
	private JTextArea address;
	private String currentUser;
	private JTextField productName;
	private JTextField productCost;
	private JTextField shippingCost;
	private JTextField returnTimeframe;
	private JList<String> newProductIdsList;
	private Product[] newProducts;
	private JSplitPane splitPane;
	private JTextField productType;
	private JTextField productSubType;
	private JList<String> userTypesList;
	private JList<String> productTypesList;
	private JList<String> productSubTypesList;
	private String currentProductUserType;
	private String currentProductType;
	private String currentProductSubType;
	private JSplitPane resultsSplitPane;
	private JList<String> searchResultsList;
	private Product[] searchResults;
	private JList<String> itemsInCartList;
	private JSplitPane shoppingCartPane;
	private JSplitPane shippingAddressPane;
	private Product[] productsInCart;
	private String currentOrderId;
	private JPanel productInfoPanel;
	private JPasswordField confirmPasswordField;
	private String currentProductId;
	//view cart button
	private JButton btnNewButton_1;
	private JSplitPane ordersListPane;
	private JTextField orderIdTf;
 	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmOnlineShoppingSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		try {
			SetupInitialData.generate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOnlineShoppingSystem = new JFrame();
		frmOnlineShoppingSystem.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frmOnlineShoppingSystem.setTitle("Online Shopping System");
		frmOnlineShoppingSystem.setBounds(screenSize.width/5, 100, 1200, 900);
		frmOnlineShoppingSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOnlineShoppingSystem.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel welcomePanel = new JPanel();
		frmOnlineShoppingSystem.getContentPane().add(welcomePanel, "name_148780737385024");
		welcomePanel.setLayout(null);
		welcomePanel.setVisible(true);
		
		JPanel signupPanel = new JPanel();
		frmOnlineShoppingSystem.getContentPane().add(signupPanel, "name_148784694801538");
		signupPanel.setLayout(null);
		signupPanel.setVisible(false);
		
		JPanel loginPanel = new JPanel();
		frmOnlineShoppingSystem.getContentPane().add(loginPanel, "name_149399017072323");
		loginPanel.setLayout(null);
		loginPanel.setVisible(false);
		
		JPanel userPanel = new JPanel();
		frmOnlineShoppingSystem.getContentPane().add(userPanel, "name_168070899689167");
		userPanel.setLayout(null);
		userPanel.setVisible(false);
		
		JPanel adminPanel = new JPanel();
		frmOnlineShoppingSystem.getContentPane().add(adminPanel, "name_168100499478302");
		adminPanel.setLayout(null);
		adminPanel.setVisible(false);
		
		JPanel addProductPanel = new JPanel();
		frmOnlineShoppingSystem.getContentPane().add(addProductPanel, "name_169470746844691");
		addProductPanel.setLayout(null);
		addProductPanel.setVisible(false);
		
		JPanel productVerificationPanel = new JPanel();
		frmOnlineShoppingSystem.getContentPane().add(productVerificationPanel, "name_171638775412341");
		
		JPanel filterPanel = new JPanel();
		frmOnlineShoppingSystem.getContentPane().add(filterPanel, "name_235127709877342");
		filterPanel.setLayout(null);
		
		JPanel searchResultsPanel = new JPanel();
		frmOnlineShoppingSystem.getContentPane().add(searchResultsPanel, "name_241082443124401");
		searchResultsPanel.setLayout(null);
		
		JPanel shoppingCartPanel = new JPanel();
		frmOnlineShoppingSystem.getContentPane().add(shoppingCartPanel, "name_313825758660195");
		shoppingCartPanel.setLayout(null);
		
		JPanel shippingAddressPanel = new JPanel();
		frmOnlineShoppingSystem.getContentPane().add(shippingAddressPanel, "name_1115487815639639");
		shippingAddressPanel.setLayout(null);
		
		JPanel paymentDetailsPanel = new JPanel();
		frmOnlineShoppingSystem.getContentPane().add(paymentDetailsPanel, "name_1125347836786809");
		paymentDetailsPanel.setLayout(null);
		
		JPanel invoicePanel = new JPanel();
		frmOnlineShoppingSystem.getContentPane().add(invoicePanel, "name_1173006826042557");
		invoicePanel.setLayout(null);
		
		JPanel ordersListPanel = new JPanel();
		frmOnlineShoppingSystem.getContentPane().add(ordersListPanel, "name_1214106940497225");
		ordersListPanel.setLayout(null);
		
		JPanel updateOrderStatusPanel = new JPanel();
		frmOnlineShoppingSystem.getContentPane().add(updateOrderStatusPanel, "name_1224358877777170");
		updateOrderStatusPanel.setLayout(null);
		
		JLabel lblProvideShippingDetails = new JLabel("Provide Shipping Details");
		lblProvideShippingDetails.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblProvideShippingDetails.setBounds(496, 99, 272, 38);
		shippingAddressPanel.add(lblProvideShippingDetails);
		
		JComboBox productsComboBox = new JComboBox();
		productsComboBox.setBounds(496, 169, 214, 22);
		shippingAddressPanel.add(productsComboBox);
		
		JTextArea shippingAddress = new JTextArea();
		shippingAddress.setBounds(496, 226, 214, 69);
		shippingAddressPanel.add(shippingAddress);
		
		JButton btnAddAddress = new JButton("Add address");
		btnAddAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(shippingAddress.getText().length()>0) {
					JOptionPane.showMessageDialog(null, "Address added");
					new ShippingDetails().addShippingAddress(currentOrderId, productsComboBox.getSelectedItem().toString()+":"+shippingAddress.getText().replaceAll(",", "_"));
					new ShoppingCart().removeFromCart(currentUser, currentProductId);
					shippingAddress.setText("");
					//refresh list
					productsComboBox.removeAllItems();
					shippingAddressPanel.revalidate();
					shippingAddressPanel.repaint();
					
					productsInCart=new ShoppingCart().getProductsInCart(currentUser);
					
					if(productsInCart.length==0) {
						//move to payment page
						
						JLabel lblProvidePaymentDetails = new JLabel("Provide Payment Details");
						lblProvidePaymentDetails.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
						lblProvidePaymentDetails.setBounds(496, 99, 272, 38);
						paymentDetailsPanel.add(lblProvidePaymentDetails);
						
						OrderDetails orderDetails = new OrderDetails().getOrderDetails(currentOrderId);
						
						int y=100;
						
						for(Product p : orderDetails.products) {
							JLabel productName = new JLabel(p.productName);
							productName.setBounds(510, y, 300, 200);
							JLabel productCost = new JLabel(""+p.productCost);
							productCost.setBounds(670, y, 300, 200);
							paymentDetailsPanel.add(productName);
							paymentDetailsPanel.add(productCost);
							y=y+20;
						}
						
						y=y+30;
						
						//display total cost
						JLabel totalCostLabel = new JLabel("Total Cost");
						totalCostLabel.setBounds(510, y, 300, 200);
						JLabel totalCostValue = new JLabel(""+orderDetails.totalCost);
						totalCostValue.setBounds(670, y, 300, 200);
						paymentDetailsPanel.add(totalCostLabel);
						paymentDetailsPanel.add(totalCostValue);
						
						y=y+20;
						
						//display payable amount
						JLabel paymentAmtLabel = new JLabel("Payable Amount");
						paymentAmtLabel.setBounds(510, y, 300, 200);
						int payableAmt = orderDetails.payableAmount;
						JLabel paymentAmtValue = new JLabel(""+payableAmt);
						paymentAmtValue.setBounds(670, y, 300, 200);
						paymentDetailsPanel.add(paymentAmtLabel);
						paymentDetailsPanel.add(paymentAmtValue);
						
						y+=130;
						
						//display text fields
						JLabel amountToPayLbl = new JLabel("Amount");
						amountToPayLbl.setBounds(510, y, 100, 20);
						JTextField amountToPay = new JTextField();
						amountToPay.setBounds(670, y+5, 100, 20);
						paymentDetailsPanel.add(amountToPayLbl);
						paymentDetailsPanel.add(amountToPay);
						
						y+=30;
						
						JLabel cardNoLbl = new JLabel("Card No");
						cardNoLbl.setBounds(510, y, 100, 20);
						JTextField cardNo = new JTextField();
						cardNo.setBounds(670, y+5, 100, 20);
						paymentDetailsPanel.add(cardNoLbl);
						paymentDetailsPanel.add(cardNo);
						
						y=y+50;
						
						JButton pay = new JButton("Pay");
						pay.setBounds(550, y, 100, 20);
						paymentDetailsPanel.add(pay);
						
						pay.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									Integer.valueOf(amountToPay.getText());
								}catch(Exception exp) {
									JOptionPane.showMessageDialog(null, "Amount can only be a number");
									return;
								}
								if(Integer.valueOf(amountToPay.getText())<payableAmt) {
									JOptionPane.showMessageDialog(null, "Amount should be atleast payable amount");
									return;
								}
								if(cardNo.getText().length()==0) {
									JOptionPane.showMessageDialog(null, "Card info cant be empty");
									return;
								}
								JOptionPane.showMessageDialog(null, "Payment done");
								new PaymentDetails(currentOrderId,Integer.valueOf(amountToPay.getText())).addPaymentDetails();
								new Invoice(currentOrderId, 
										orderDetails.totalCost, 
										Integer.valueOf(amountToPay.getText()),
										new ShippingDetails().getShippingDetails(currentOrderId)).addInvoice();
								
								paymentDetailsPanel.removeAll();
								paymentDetailsPanel.revalidate();
								paymentDetailsPanel.repaint();
								
								//move to invoice page
								JLabel lblInvoice = new JLabel("Order Summary");
								lblInvoice.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
								lblInvoice.setBounds(540, 99, 272, 38);
								invoicePanel.add(lblInvoice);
								
								JTextField orderIdtf= new JTextField(" Order ID "+currentOrderId);
								orderIdtf.setEditable(false);
								orderIdtf.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
								orderIdtf.setBounds(510, 140, 200, 38);
								invoicePanel.add(orderIdtf);
								
								int y=90;
								
								for(Product p : orderDetails.products) {
									JLabel productName = new JLabel(p.productName);
									productName.setBounds(510, y, 300, 200);
									JLabel productCost = new JLabel(""+p.productCost);
									productCost.setBounds(670, y, 300, 200);
									invoicePanel.add(productName);
									invoicePanel.add(productCost);
									y=y+20;
								}
								
								y=y+30;
								
								JLabel label = new JLabel("Shipping addresses");
								label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
								label.setBounds(540, y, 300, 200);
								invoicePanel.add(label);
								
								y=y+40;
								
								String addressesList = new ShippingDetails().getShippingDetails(currentOrderId);
								String[] addresses = addressesList.split(",");
								for(String address:addresses) {
									String[] part = address.split(":");
									JLabel productName = new JLabel(part[0]);
									productName.setBounds(510, y, 300, 200);
									JLabel shippingAddress = new JLabel(part[1].replaceAll("_", ","));
									shippingAddress.setBounds(670, y, 300, 200);
									invoicePanel.add(productName);
									invoicePanel.add(shippingAddress);
									y=y+20;
								}
									
								y=y+30;
								
								label = new JLabel("Billing Details");
								label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
								label.setBounds(555, y, 300, 200);
								invoicePanel.add(label);
								
								y=y+40;
								
								//display total cost
								JLabel totalCostLabel = new JLabel("Total Cost");
								totalCostLabel.setBounds(510, y, 300, 200);
								JLabel totalCostValue = new JLabel(""+orderDetails.totalCost);
								totalCostValue.setBounds(670, y, 300, 200);
								invoicePanel.add(totalCostLabel);
								invoicePanel.add(totalCostValue);
								
								y=y+30;	
								JLabel amountPaidLbl = new JLabel("Amount Paid");
								amountPaidLbl.setBounds(510, y, 300, 200);
								JLabel amountPaidValue = new JLabel(""+new PaymentDetails().getAmountPaid(currentOrderId));
								amountPaidValue.setBounds(670, y, 300, 200);
								invoicePanel.add(amountPaidLbl);
								invoicePanel.add(amountPaidValue);
								
								y=y+30;	
								JLabel amountDueLbl = new JLabel("Amount Due");
								amountDueLbl.setBounds(510, y, 300, 200);
								JLabel amountDueValue = new JLabel(""+new Invoice().getAmountDue(currentOrderId));
								amountDueValue.setBounds(670, y, 300, 200);
								invoicePanel.add(amountDueLbl);
								invoicePanel.add(amountDueValue);
								
								y=y+160;	
								JButton cntShopping = new JButton("Continue Shopping");
								cntShopping.setBounds(530, y, 165, 30);
								invoicePanel.add(cntShopping);
								
								cntShopping.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										invoicePanel.removeAll();
										invoicePanel.revalidate();
										invoicePanel.repaint();
										invoicePanel.setVisible(false);
										userPanel.setVisible(true);
									}
								});
								
								paymentDetailsPanel.setVisible(false);
								invoicePanel.setVisible(true);
								
							}
						});
						
						paymentDetailsPanel.setVisible(true);
						paymentDetailsPanel.revalidate();
						paymentDetailsPanel.repaint();
						shippingAddressPanel.setVisible(false);
						
						return;
					}
					String[] productNames = new String[productsInCart.length];
					int index=0;
					for(Product p:productsInCart) {
						productNames[index++]=p.productName;
						productsComboBox.addItem(p.productName);
					}
					
					currentProductId = productsInCart[0].productId;
					
					productsComboBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(productsComboBox.getSelectedIndex()>0) {
								currentProductId=productsInCart[productsComboBox.getSelectedIndex()].productId;
							}
						}
					});
					
					shippingAddressPanel.revalidate();
					shippingAddressPanel.repaint();
					
				}else {
					JOptionPane.showMessageDialog(null, "Shipping address cant be empty");
				}
			}
		});
		btnAddAddress.setBounds(548, 347, 113, 25);
		shippingAddressPanel.add(btnAddAddress);
		
		JLabel lblYourShoppingCart = new JLabel("Your Shopping Cart");
		lblYourShoppingCart.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblYourShoppingCart.setBounds(496, 99, 311, 45);
		shoppingCartPanel.add(lblYourShoppingCart);
		
		JButton button_6 = new JButton("<< Back");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				searchResultsPanel.remove(resultsSplitPane);
				
				searchResults = new Product().searchProducts(currentProductUserType, currentProductType, currentProductSubType);
				
				//display search results				
				String[] productNames = new String[searchResults.length];
				int i=0;
				for(Product p:searchResults) {
					productNames[i++]=p.productName;
				}
				searchResultsList = new JList<String>(productNames);
				JScrollPane listScrollPane = new JScrollPane(searchResultsList);
				productInfoPanel = new JPanel();
				productInfoPanel.setLayout(new GridLayout(0, 1));
				JLabel productCost = new JLabel();
				JLabel shippingCost = new JLabel();
				JLabel CODFlag = new JLabel();
				JLabel returnFlag = new JLabel();
				productInfoPanel.add(productCost);
				productInfoPanel.add(shippingCost);
				productInfoPanel.add(CODFlag);
				productInfoPanel.add(returnFlag);
				resultsSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,listScrollPane,productInfoPanel);
				
				searchResultsList.addListSelectionListener(new ListSelectionListener() {						
					public void valueChanged(ListSelectionEvent e) {
						// TODO Auto-generated method stub
						if(searchResultsList.getSelectedIndices().length>0) {
							productCost.setText("Product Cost: "+searchResults[searchResultsList.getSelectedIndex()].productCost);
							shippingCost.setText("Shipping Cost: "+searchResults[searchResultsList.getSelectedIndex()].shippingCost);
							CODFlag.setText("COD Eligible: "+searchResults[searchResultsList.getSelectedIndex()].CODFlag);
							returnFlag.setText("Return Time Frame: "+searchResults[searchResultsList.getSelectedIndex()].returnTimeframe);
							resultsSplitPane.revalidate();
							resultsSplitPane.repaint();
						}
					}
				});
				
				resultsSplitPane.setBounds(200, 150, 800, 600);
				resultsSplitPane.setDividerLocation(0.4);
				searchResultsPanel.add(resultsSplitPane);						
				
				shoppingCartPanel.setVisible(false);
				searchResultsPanel.setVisible(true);
				searchResultsPanel.revalidate();
				searchResultsPanel.repaint();
			}
		});
		button_6.setBounds(0, 0, 190, 45);
		shoppingCartPanel.add(button_6);
		
		JButton btnRemoveProduct = new JButton("Remove Product");
		btnRemoveProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shoppingCartPanel.remove(shoppingCartPane);
				int[] selectedProductIndices=itemsInCartList.getSelectedIndices();
				if(selectedProductIndices.length<0){
					JOptionPane.showMessageDialog(null,"Please select any item to remove from cart");
					return;
				}
				for(int i:selectedProductIndices) {
					new Product().updateProductStatus(productsInCart[i].productId, "VERIFIED");
					new ShoppingCart().removeFromCart(currentUser, productsInCart[i].productId);
				}
				shoppingCartPanel.remove(shoppingCartPane);
				productsInCart=new ShoppingCart().getProductsInCart(currentUser);
				
				//refreshing search results list
				if(productsInCart.length==0) {
					JOptionPane.showMessageDialog(null,"Nothing in cart now");
					shoppingCartPanel.remove(shoppingCartPane);
					searchResultsPanel.remove(resultsSplitPane);
					
					searchResults = new Product().searchProducts(currentProductUserType, currentProductType, currentProductSubType);
						
					String[] productNames = new String[searchResults.length];
					int i=0;
					for(Product p:searchResults) {
						productNames[i++]=p.productName;
					}
					searchResultsList = new JList<String>(productNames);
					JScrollPane listScrollPane = new JScrollPane(searchResultsList);	
					productInfoPanel = new JPanel();
					productInfoPanel.setLayout(new GridLayout(0, 1));
					JLabel productCost = new JLabel();
					JLabel shippingCost = new JLabel();
					JLabel CODFlag = new JLabel();
					JLabel returnFlag = new JLabel();
					productInfoPanel.add(productCost);
					productInfoPanel.add(shippingCost);
					productInfoPanel.add(CODFlag);
					productInfoPanel.add(returnFlag);
					resultsSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,listScrollPane,productInfoPanel);
					
					searchResultsList.addListSelectionListener(new ListSelectionListener() {						
						public void valueChanged(ListSelectionEvent e) {
							// TODO Auto-generated method stub
							if(searchResultsList.getSelectedIndices().length>0) {
								productCost.setText("Product Cost: "+searchResults[searchResultsList.getSelectedIndex()].productCost);
								shippingCost.setText("Shipping Cost: "+searchResults[searchResultsList.getSelectedIndex()].shippingCost);
								CODFlag.setText("COD Eligible: "+searchResults[searchResultsList.getSelectedIndex()].CODFlag);
								returnFlag.setText("Return Time Frame: "+searchResults[searchResultsList.getSelectedIndex()].returnTimeframe);
							}
						}
					});
					
					resultsSplitPane.setBounds(200, 150, 800, 600);
					resultsSplitPane.setDividerLocation(0.4);
					searchResultsPanel.add(resultsSplitPane);						
					searchResultsPanel.setVisible(true);					
					shoppingCartPanel.setVisible(false);				
					return;
				}
				
				//refresh shopping cart list
				productInfoPanel = new JPanel();
				productInfoPanel.setLayout(new GridLayout(0, 1));
				JLabel productCost = new JLabel();
				JLabel shippingCost = new JLabel();
				JLabel CODFlag = new JLabel();
				JLabel returnFlag = new JLabel();
				productInfoPanel.add(productCost);
				productInfoPanel.add(shippingCost);
				productInfoPanel.add(CODFlag);
				productInfoPanel.add(returnFlag);
				String[] productNames = new String[productsInCart.length];
				int index=0;
				for(Product p:productsInCart) {
					productNames[index++]=p.productName;
				}
				itemsInCartList=new JList<>(productNames);
				JScrollPane listScrollPane = new JScrollPane(itemsInCartList);	
				shoppingCartPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,listScrollPane,productInfoPanel);
				
				itemsInCartList.addListSelectionListener(new ListSelectionListener() {						
					public void valueChanged(ListSelectionEvent e) {
						// TODO Auto-generated method stub
						if(itemsInCartList.getSelectedIndices().length>0) {
							productCost.setText("Product Cost: "+productsInCart[itemsInCartList.getSelectedIndex()].productCost);
							shippingCost.setText("Shipping Cost: "+productsInCart[itemsInCartList.getSelectedIndex()].shippingCost);
							CODFlag.setText("COD Eligible: "+productsInCart[itemsInCartList.getSelectedIndex()].CODFlag);
							returnFlag.setText("Return Time Frame: "+productsInCart[itemsInCartList.getSelectedIndex()].returnTimeframe);
						}
					}
				});
				
				shoppingCartPane.setBounds(200, 150, 800, 600);
				shoppingCartPane.setDividerLocation(0.4);
				shoppingCartPanel.add(shoppingCartPane);
				shoppingCartPanel.revalidate();
				shoppingCartPanel.repaint();
			}
		});
		btnRemoveProduct.setBounds(371, 779, 190, 45);
		shoppingCartPanel.add(btnRemoveProduct);
		
		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice=JOptionPane.showConfirmDialog(null, "This will confirm your order, are you sure?");
				if(choice==0) {
					String orderId=String.valueOf(System.currentTimeMillis());
					new Order(currentUser,orderId).createOrder();					
					new OrderDetails(orderId,productsInCart,new Date(System.currentTimeMillis()).toString()).createOrderDetails(orderId);
					for(Product p:productsInCart) {
						new Product().updateProductStatus(p.productId, "SOLD");
					}
					currentOrderId=orderId;
					shoppingCartPanel.remove(shoppingCartPane);
					
					//accept shipping details here
					productsInCart=new ShoppingCart().getProductsInCart(currentUser);
					
					String[] productNames = new String[productsInCart.length];
					int index=0;
					for(Product p:productsInCart) {
						productNames[index++]=p.productName;
						productsComboBox.addItem(p.productName);
					}
					
					currentProductId = productsInCart[0].productId;
					
					productsComboBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(productsComboBox.getSelectedIndex()>0)
								currentProductId=productsInCart[productsComboBox.getSelectedIndex()].productId;
						}
					});
					
					shoppingCartPanel.setVisible(false);
					shippingAddressPanel.setVisible(true);
					
				}
			}
		});
		btnCheckout.setBounds(651, 779, 190, 45);
		shoppingCartPanel.add(btnCheckout);
		
		JButton button_3 = new JButton("<< Back");
		button_3.setBounds(0, 0, 190, 45);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productVerificationPanel.remove(splitPane);
				productVerificationPanel.setVisible(false);
				adminPanel.setVisible(true);
			}
		});
		productVerificationPanel.setLayout(null);
		productVerificationPanel.add(button_3);
		
		JLabel lblSelectProductsTo = new JLabel("Select products to verify");
		lblSelectProductsTo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblSelectProductsTo.setBounds(506, 97, 311, 45);
		productVerificationPanel.add(lblSelectProductsTo);
		
		productVerificationPanel.setVisible(false);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signupPanel.setVisible(true);
				welcomePanel.setVisible(false);
				
			}
		});
		btnSignUp.setBounds(365, 783, 190, 45);
		welcomePanel.add(btnSignUp);
		
		JLabel lblWelcomeToOnline = new JLabel(new ImageIcon("images/online-shopping-banner.png"));
		lblWelcomeToOnline.setBounds(170, 47, 850, 250);
		welcomePanel.add(lblWelcomeToOnline);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginPanel.setVisible(true);
				welcomePanel.setVisible(false);
			}
		});
		btnLogin.setBounds(681, 783, 190, 45);
		welcomePanel.add(btnLogin);
		
		JLabel lblBestDeals = new JLabel(new ImageIcon("images/discount.png"));
		lblBestDeals.setBounds(700, 265, 295, 510);
		welcomePanel.add(lblBestDeals);
		
		JLabel lblQuote = new JLabel(new ImageIcon("images/quote1.jpg"));
		lblQuote.setBounds(195, 300, 500, 450);
		welcomePanel.add(lblQuote);
		
		
		JLabel lblSignupPlease = new JLabel("Please provide details:");
		lblSignupPlease.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblSignupPlease.setBounds(506, 97, 311, 45);
		signupPanel.add(lblSignupPlease);
		
		JLabel lblEmailId = new JLabel("Email ID");
		lblEmailId.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblEmailId.setBounds(418, 198, 91, 16);
		signupPanel.add(lblEmailId);
		
		tfEmailID = new JTextField();
		tfEmailID.setBounds(645, 190, 242, 34);
		signupPanel.add(tfEmailID);
		tfEmailID.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblPassword.setBounds(418, 280, 108, 16);
		signupPanel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(645, 272, 242, 34);
		signupPanel.add(passwordField);
		
		JButton btnDone = new JButton("Sign Up");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfEmailID.getText().length()==0 || passwordField.getPassword().length==0 || confirmPasswordField.getPassword().length==0
						||firstName.getText().length()==0||lastName.getText().length()==0||address.getText().length()==0) {
					JOptionPane.showMessageDialog(null,"All fields are required");
					return;
				}
				if(!String.valueOf(passwordField.getPassword()).equals(String.valueOf(confirmPasswordField.getPassword()))) {
					JOptionPane.showMessageDialog(null,"Passwords dont match");
					return;
				}
				int status = new User(tfEmailID.getText(), String.valueOf(passwordField.getPassword())).register();
				if(status == 0) {
					JOptionPane.showMessageDialog(null,"Email already in use");
				}else {
					new Consumer(tfEmailID.getText(),firstName.getText(),lastName.getText(),address.getText()).addConsumer();
					JOptionPane.showMessageDialog(null,"Sign up successful");
					tfEmailID.setText(null);
					passwordField.setText(null);
					confirmPasswordField.setText(null);
					firstName.setText(null);
					lastName.setText(null);
					address.setText(null);
					signupPanel.setVisible(false);
					welcomePanel.setVisible(true);
				}
			}
		});
		btnDone.setBounds(506, 767, 190, 45);
		signupPanel.add(btnDone);
		
		JButton button = new JButton("<<Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signupPanel.setVisible(false);
				welcomePanel.setVisible(true);
				
			}
		});
		button.setBounds(0, 0, 190, 45);
		signupPanel.add(button);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblFirstName.setBounds(418, 432, 91, 16);
		signupPanel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblLastName.setBounds(418, 511, 91, 16);
		signupPanel.add(lblLastName);
		
		firstName = new JTextField();
		firstName.setBounds(645, 424, 242, 34);
		signupPanel.add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setBounds(645, 503, 242, 34);
		signupPanel.add(lastName);
		lastName.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAddress.setBounds(418, 600, 119, 16);
		signupPanel.add(lblAddress);
		
		address = new JTextArea();
		address.setBounds(645, 598, 242, 94);
		signupPanel.add(address);
		
		JLabel confirmPassword = new JLabel("Confirm Password");
		confirmPassword.setFont(new Font("Times New Roman", Font.BOLD, 17));
		confirmPassword.setBounds(418, 356, 167, 16);
		signupPanel.add(confirmPassword);
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(645, 348, 242, 34);
		signupPanel.add(confirmPasswordField);
		
		JLabel lblPleaseProvideDetails = new JLabel("Please provide details:");
		lblPleaseProvideDetails.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblPleaseProvideDetails.setBounds(506, 97, 311, 45);
		loginPanel.add(lblPleaseProvideDetails);
		
		JLabel label = new JLabel("Email ID");
		label.setFont(new Font("Times New Roman", Font.BOLD, 17));
		label.setBounds(418, 198, 91, 16);
		loginPanel.add(label);
		
		emailID = new JTextField();
		emailID.setColumns(10);
		emailID.setBounds(645, 190, 242, 34);
		loginPanel.add(emailID);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(645, 272, 242, 34);
		loginPanel.add(passwordField_1);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		label_1.setBounds(418, 280, 108, 16);
		loginPanel.add(label_1);
		
		JButton btnLogin_1 = new JButton("Login");
		btnLogin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(emailID.getText().equals("admin") && new User("admin",String.valueOf(passwordField_1.getPassword())).login()==1) {
					currentUser=emailID.getText();
					emailID.setText(null);
					passwordField_1.setText(null);
					loginPanel.setVisible(false);
					adminPanel.setVisible(true);
					return;
				}
				
				if(emailID.getText().length()==0) {
					JOptionPane.showMessageDialog(null,"EmailID cannot be empty");
					return;
				}
				if(passwordField_1.getPassword().length==0) {
					JOptionPane.showMessageDialog(null,"Password cannot be empty");
					return;
				}
				User temp = new User(emailID.getText(), String.valueOf(passwordField_1.getPassword()));
				int status = temp.login();
				if(status==0) {
					JOptionPane.showMessageDialog(null,"No such user exists");
				}else if(status==1) {
						currentUser=emailID.getText();
						emailID.setText(null);
						passwordField_1.setText(null);
						loginPanel.setVisible(false);
						userPanel.setVisible(true);
				}else if(status==-1) {
					JOptionPane.showMessageDialog(null,"Password mismatch");	
				}
			}
		});
		btnLogin_1.setBounds(506, 391, 190, 45);
		loginPanel.add(btnLogin_1);
		
		JButton button_1 = new JButton("<<Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginPanel.setVisible(false);
				welcomePanel.setVisible(true);
			}
		});
		button_1.setBounds(0, 0, 190, 45);
		loginPanel.add(button_1);
		
		JButton btnAddProducts = new JButton("Sell Products");
		btnAddProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userPanel.setVisible(false);
				addProductPanel.setVisible(true);
			}
		});
		btnAddProducts.setBounds(502, 208, 190, 45);
		userPanel.add(btnAddProducts);
		
		JButton btnNewButton = new JButton("Buy Products");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(new Product().getProductTypes().length==0) {
					JOptionPane.showMessageDialog(null,"No products to buy");
					return;
				}
				
				JButton button_4 = new JButton("<< Back");
				button_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						filterPanel.remove(userTypesList);
						filterPanel.remove(productTypesList);
						filterPanel.remove(productSubTypesList);
						filterPanel.repaint();
						filterPanel.setVisible(false);
						userPanel.setVisible(true);
					}
				});
				
				JLabel lblWhatTypeOf = new JLabel("What type of product are you looking for?");
				lblWhatTypeOf.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
				lblWhatTypeOf.setBounds(433, 45, 461, 45);
				filterPanel.add(lblWhatTypeOf);
				
				JLabel lblFor = new JLabel("For?");
				lblFor.setFont(new Font("Times New Roman", Font.BOLD, 17));
				lblFor.setBounds(584, 110, 56, 16);
				filterPanel.add(lblFor);
				
				JLabel lblProductType_1 = new JLabel("Product Type?");
				lblProductType_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
				lblProductType_1.setBounds(559, 250, 110, 16);
				filterPanel.add(lblProductType_1);
				
				JLabel lblProductSubType_1 = new JLabel("Product Sub Type?");
				lblProductSubType_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
				lblProductSubType_1.setBounds(548, 477, 173, 27);
				filterPanel.add(lblProductSubType_1);
				
				JButton btnSearch = new JButton("Search");
				btnSearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(currentProductUserType==null || currentProductType == null || currentProductSubType == null) {
							JOptionPane.showMessageDialog(null,"Please make one selection from each list");
						}else {
							searchResults = new Product().searchProducts(currentProductUserType, currentProductType, currentProductSubType);
							if(searchResults.length==0) 
								JOptionPane.showMessageDialog(null,"Search returned no results");
							else {
								//display search results
								filterPanel.removeAll();
								filterPanel.setVisible(false);
								
								String[] productNames = new String[searchResults.length];
								int i=0;
								for(Product p:searchResults) {
									productNames[i++]=p.productName;
								}
								searchResultsList = new JList<String>(productNames);
								JScrollPane listScrollPane = new JScrollPane(searchResultsList);
								productInfoPanel = new JPanel();
								productInfoPanel.setLayout(new GridLayout(0, 1));
								JLabel productCost = new JLabel();
								JLabel shippingCost = new JLabel();
								JLabel CODFlag = new JLabel();
								JLabel returnFlag = new JLabel();
								productInfoPanel.add(productCost);
								productInfoPanel.add(shippingCost);
								productInfoPanel.add(CODFlag);
								productInfoPanel.add(returnFlag);
								resultsSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,listScrollPane,productInfoPanel);
								
								searchResultsList.addListSelectionListener(new ListSelectionListener() {						
									public void valueChanged(ListSelectionEvent e) {
										// TODO Auto-generated method stub
										if(searchResultsList.getSelectedIndices().length>0) {
											productCost.setText("Product Cost: "+searchResults[searchResultsList.getSelectedIndex()].productCost);
											shippingCost.setText("Shipping Cost: "+searchResults[searchResultsList.getSelectedIndex()].shippingCost);
											CODFlag.setText("COD Eligible: "+searchResults[searchResultsList.getSelectedIndex()].CODFlag);
											returnFlag.setText("Return Time Frame: "+searchResults[searchResultsList.getSelectedIndex()].returnTimeframe);
										}
									}
								});
								
								resultsSplitPane.setBounds(200, 150, 800, 600);
								resultsSplitPane.setDividerLocation(0.4);
								searchResultsPanel.add(resultsSplitPane);						
								
								searchResultsPanel.setVisible(true);
							}
						}
					}
				});
				btnSearch.setBounds(531, 764, 190, 45);
				filterPanel.add(btnSearch);
				
				button_4.setBounds(0, 0, 190, 45);
				filterPanel.add(button_4);
				
				userPanel.setVisible(false);
				//displaying product user type list
				String[] userTypes = {"Male","Female","Any"};
				userTypesList = new JList<String>(userTypes);
				userTypesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				userTypesList.setBounds(550, 140, 100, 70);
				filterPanel.add(userTypesList);
				
				userTypesList.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						if(userTypesList.getSelectedIndex()>=0)
							currentProductUserType=userTypesList.getSelectedValue();
						else
							currentProductUserType=null;
					}
				});
				
				//displaying product types list
				String[] productTypes = new Product().getProductTypes();
				productTypesList = new JList<String>(productTypes);
				productTypesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				productTypesList.setBounds(520, 280, 200, 170);
				filterPanel.add(productTypesList);
				
				//displaying product sub types list
				productTypesList.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						if(productTypesList.getSelectedIndex()<0) {
							currentProductType=null;
							return;
						}
						String productType = productTypesList.getSelectedValue();
						currentProductType=productType;
						new Product();
						if(productSubTypesList!=null) {
							filterPanel.remove(productSubTypesList);
							filterPanel.repaint();
						}
						String[] productSubTypes = new Product().getProductSubTypes(productType);
						productSubTypesList = new JList<String>(productSubTypes);
						productSubTypesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						productSubTypesList.setBounds(520, 520, 200, 170);
						
						productSubTypesList.addListSelectionListener(new ListSelectionListener() {
							public void valueChanged(ListSelectionEvent e) {
								if(productSubTypesList.getSelectedIndex()<0) {
									currentProductSubType=null;
									return;
								}currentProductSubType=productSubTypesList.getSelectedValue();
							}
						});
						
						filterPanel.add(productSubTypesList);
						filterPanel.repaint();
					}
				});
				
				filterPanel.setVisible(true);
			}
		});
		btnNewButton.setBounds(502, 350, 190, 45);
		userPanel.add(btnNewButton);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userPanel.setVisible(false);
				currentUser=null;
				welcomePanel.setVisible(true);
			}
		});
		logout.setBounds(1004, 0, 190, 45);
		userPanel.add(logout);
		
		JLabel welcomeMessage = new JLabel("Welcome Back");
		welcomeMessage.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		welcomeMessage.setBounds(536, 96, 179, 45);
		userPanel.add(welcomeMessage);
		
		JButton cancelOrderBtn = new JButton("Cancel Order");
		cancelOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JButton back = new JButton("<<Back");
				back.setBounds(0, 0, 190, 45);
				ordersListPanel.add(back);
				back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ordersListPanel.removeAll();
						ordersListPanel.setVisible(false);
						userPanel.setVisible(true);						
					}
				});
				Order[] orders = new Order().getOrders(currentOrderId,"CREATED");
				if(orders.length==0) {
					JOptionPane.showMessageDialog(null, "No orders to cancel");
				}
				else {
					JLabel ordersListLbl = new JLabel("List Of Orders");
					ordersListLbl.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
					ordersListLbl.setBounds(520, 99, 272, 38);
					ordersListPanel.add(ordersListLbl);
					
					String[] orderIds = new String[orders.length]; 
					int i=0;
					for(Order order:orders) {
						orderIds[i++]=order.orderId;
					}
					
					JList<String> orderIdsList = new JList<>(orderIds);
					orderIdsList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
					
					JPanel productListPanel = new JPanel();
					productListPanel.setLayout(new GridLayout(0, 1));
					
					ordersListPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,orderIdsList,productListPanel);
					ordersListPane.setBounds(380, 150, 400, 400);
					ordersListPane.setDividerLocation(0.4);
					ordersListPanel.add(ordersListPane);
					
					JButton cancelBtn = new JButton("Cancel Order");
					cancelBtn.setBounds(500, 650, 150, 30);
					ordersListPanel.add(cancelBtn);
					
					cancelBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(orderIdsList.getSelectedValue()==null)
								JOptionPane.showMessageDialog(null, "Select order to cancel");
							else {
								new OrderDetails().updateOrderStatus(orderIdsList.getSelectedValue(), "CANCELLED");
								Product[] products = new OrderDetails().getProducts(orderIdsList.getSelectedValue());
								for(Product p:products) {
									new Product().updateProductStatus(p.productId, "VERIFIED");
								}
								JOptionPane.showMessageDialog(null, "Order Cancelled");
								ordersListPanel.removeAll();
								
								ordersListPanel.revalidate();
								ordersListPanel.repaint();
								ordersListPanel.setVisible(false);
								userPanel.setVisible(true);
								if(new Order().getOrders(currentUser,"CREATED").length>0)
									cancelOrderBtn.doClick();
							}
						}
					});
					
					orderIdsList.addListSelectionListener(new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent e) {
							productListPanel.removeAll();
							ordersListPanel.revalidate();
							ordersListPanel.repaint();
							Product[] products = new OrderDetails().getProducts(orderIdsList.getSelectedValue());
							for(Product p:products) {
								JLabel label = new JLabel(p.productName);
								productListPanel.add(label);
							}
							JLabel label = new JLabel("Date Placed "+new OrderDetails().getOrderDetails(orderIdsList.getSelectedValue()).datePlaced);
							productListPanel.add(label);
							ordersListPanel.revalidate();
							ordersListPanel.repaint();
						}
					});
					
					ordersListPanel.setVisible(true);
					userPanel.setVisible(false);
					
				}
			}
		});
		cancelOrderBtn.setBounds(502, 493, 190, 45);
		userPanel.add(cancelOrderBtn);
		
		JButton btnReturnOrder = new JButton("Return Order");
		btnReturnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JButton back = new JButton("<<Back");
				back.setBounds(0, 0, 190, 45);
				ordersListPanel.add(back);
				back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ordersListPanel.removeAll();
						ordersListPanel.setVisible(false);
						userPanel.setVisible(true);						
					}
				});
				Order[] orders = new Order().getOrders(currentOrderId,"COMPLETED");
				if(orders.length==0) {
					JOptionPane.showMessageDialog(null, "No orders to return");
				}
				else {
					JLabel ordersListLbl = new JLabel("List Of Orders");
					ordersListLbl.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
					ordersListLbl.setBounds(520, 99, 272, 38);
					ordersListPanel.add(ordersListLbl);
					
					String[] orderIds = new String[orders.length]; 
					int i=0;
					for(Order order:orders) {
						orderIds[i++]=order.orderId;
					}
					
					JList<String> orderIdsList = new JList<>(orderIds);
					orderIdsList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
					
					JPanel productListPanel = new JPanel();
					productListPanel.setLayout(new GridLayout(0, 1));
					
					ordersListPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,orderIdsList,productListPanel);
					ordersListPane.setBounds(380, 150, 400, 400);
					ordersListPane.setDividerLocation(0.4);
					ordersListPanel.add(ordersListPane);
					
					JButton cancelBtn = new JButton("Return Order");
					cancelBtn.setBounds(500, 650, 150, 30);
					ordersListPanel.add(cancelBtn);
					
					cancelBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(orderIdsList.getSelectedValue()==null)
								JOptionPane.showMessageDialog(null, "Select order to return");
							else {
								new OrderDetails().updateOrderStatus(orderIdsList.getSelectedValue(), "RETURNED");
								Product[] products = new OrderDetails().getProducts(orderIdsList.getSelectedValue());
								for(Product p:products) {
									new Product().updateProductStatus(p.productId, "VERIFIED");
								}
								JOptionPane.showMessageDialog(null, "Order Return Initiated");
								ordersListPanel.removeAll();
								
								ordersListPanel.revalidate();
								ordersListPanel.repaint();
								ordersListPanel.setVisible(false);
								userPanel.setVisible(true);
								if(new Order().getOrders(currentUser,"COMPLETED").length>0)
									btnReturnOrder.doClick();
							}
						}
					});
					
					orderIdsList.addListSelectionListener(new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent e) {
							productListPanel.removeAll();
							ordersListPanel.revalidate();
							ordersListPanel.repaint();
							Product[] products = new OrderDetails().getProducts(orderIdsList.getSelectedValue());
							for(Product p:products) {
								JLabel label = new JLabel(p.productName);
								productListPanel.add(label);
							}
							JLabel label = new JLabel("Date Placed "+new OrderDetails().getOrderDetails(orderIdsList.getSelectedValue()).datePlaced);
							productListPanel.add(label);
							ordersListPanel.revalidate();
							ordersListPanel.repaint();
						}
					});
					
					ordersListPanel.setVisible(true);
					userPanel.setVisible(false);
					
				}
			}
		});
		btnReturnOrder.setBounds(502, 628, 190, 45);
		userPanel.add(btnReturnOrder);
		
		JButton btnVerifyNewProducts = new JButton("Verify New Products");
		btnVerifyNewProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newProducts = new Product().getNewProducts();
				if(newProducts.length==0) {
					JOptionPane.showMessageDialog(null,"No new products to verify");
				}else {
					adminPanel.setVisible(false);
					String[] newProductIds=new String[newProducts.length];
					for(int i=0;i<newProducts.length;i++) {
						newProductIds[i]=newProducts[i].productId;
					}
					
					newProductIdsList = new JList<>(newProductIds);					
					newProductIdsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);					
					JScrollPane listScrollPane = new JScrollPane(newProductIdsList);					
					productInfoPanel = new JPanel();
					productInfoPanel.setLayout(new GridLayout(0, 1));
					JLabel productName = new JLabel();
					JLabel sellerId = new JLabel();
					JLabel productCost = new JLabel();
					JLabel shippingCost = new JLabel();
					JLabel CODFlag = new JLabel();
					JLabel returnFlag = new JLabel();
					productInfoPanel.add(productName);
					productInfoPanel.add(sellerId);
					productInfoPanel.add(productCost);
					productInfoPanel.add(shippingCost);
					productInfoPanel.add(CODFlag);
					productInfoPanel.add(returnFlag);
					splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,listScrollPane,productInfoPanel);					
					splitPane.setBounds(200, 150, 800, 600);
					splitPane.setDividerLocation(0.4);
					
					newProductIdsList.addListSelectionListener(new ListSelectionListener() {						
						public void valueChanged(ListSelectionEvent e) {
							// TODO Auto-generated method stub
							if(newProductIdsList.getSelectedIndices().length>0) {
								productName.setText("Product Name: "+newProducts[newProductIdsList.getMaxSelectionIndex()].productName);
								sellerId.setText("Seller Id: "+newProducts[newProductIdsList.getMaxSelectionIndex()].sellerId);
								productCost.setText("Product Cost: "+newProducts[newProductIdsList.getMaxSelectionIndex()].productCost);
								shippingCost.setText("Shipping Cost: "+newProducts[newProductIdsList.getMaxSelectionIndex()].shippingCost);
								CODFlag.setText("COD Eligible: "+newProducts[newProductIdsList.getMaxSelectionIndex()].CODFlag);
								returnFlag.setText("Return Time Frame: "+newProducts[newProductIdsList.getMaxSelectionIndex()].returnTimeframe);
							}
						}
					});

					JButton btnVerifyProducts = new JButton("Verify Products");
					btnVerifyProducts.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							if(newProductIdsList.getSelectedIndices().length==0) {
								JOptionPane.showMessageDialog(null,"Please select products to verify");
							}else {
								String[] temp = new String[newProductIdsList.getSelectedIndices().length];
								java.util.List<String> productIds = newProductIdsList.getSelectedValuesList();
								java.util.Iterator<String> it = productIds.iterator();
								int i=0;
								while(it.hasNext()) {
									temp[i++]=it.next();
								}
								
								new Product().verifyProduct(temp);
								JOptionPane.showMessageDialog(null,"Selected product verified");
								productVerificationPanel.remove(splitPane);
								productVerificationPanel.remove(btnVerifyNewProducts);
								productVerificationPanel.setVisible(false);
								adminPanel.setVisible(true);
							}
						}
					});
					
					btnVerifyProducts.setBounds(506, 767, 190, 45);
					productVerificationPanel.add(btnVerifyProducts);
					productVerificationPanel.add(splitPane);
					productVerificationPanel.setVisible(true);
				}
			}
		});
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminPanel.setVisible(false);
				currentUser=null;
				welcomePanel.setVisible(true);
			}
		});
		btnLogout.setBounds(1004, 0, 190, 45);
		adminPanel.add(btnLogout);
		
		btnVerifyNewProducts.setBounds(523, 214, 190, 45);
		adminPanel.add(btnVerifyNewProducts);
		
		JLabel label_2 = new JLabel("Welcome Back");
		label_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		label_2.setBounds(549, 90, 179, 45);
		adminPanel.add(label_2);
		
		JButton updateOrderStatusBtn = new JButton("Update Order Status");
		updateOrderStatusBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateOrderStatusPanel.setVisible(true);
				adminPanel.setVisible(false);
			}
		});
		updateOrderStatusBtn.setBounds(523, 311, 190, 45);
		adminPanel.add(updateOrderStatusBtn);
		
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblProductName.setBounds(418, 198, 153, 16);
		addProductPanel.add(lblProductName);
		
		JLabel lblProductCost = new JLabel("Product Cost");
		lblProductCost.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblProductCost.setBounds(418, 477, 180, 25);
		addProductPanel.add(lblProductCost);
		
		JLabel lblShippingCost = new JLabel("Shipping Cost");
		lblShippingCost.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblShippingCost.setBounds(418, 558, 139, 25);
		addProductPanel.add(lblShippingCost);
		
		JCheckBox codFlag = new JCheckBox("COD Eligible");
		codFlag.setFont(new Font("Times New Roman", Font.BOLD, 17));
		codFlag.setBounds(550, 629, 150, 25);
		addProductPanel.add(codFlag);
		
		JLabel lblReturnTimeframe = new JLabel("Return TimeFrame");
		lblReturnTimeframe.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblReturnTimeframe.setBounds(421, 690, 177, 16);
		addProductPanel.add(lblReturnTimeframe);
		
		productName = new JTextField();
		productName.setBounds(645, 190, 242, 34);
		addProductPanel.add(productName);
		productName.setColumns(10);
		
		productCost = new JTextField();
		productCost.setBounds(645, 480, 242, 34);
		addProductPanel.add(productCost);
		productCost.setColumns(10);
		
		shippingCost = new JTextField();
		shippingCost.setBounds(645, 556, 242, 34);
		addProductPanel.add(shippingCost);
		shippingCost.setColumns(10);
		
		returnTimeframe = new JTextField();
		returnTimeframe.setBounds(645, 682, 242, 34);
		addProductPanel.add(returnTimeframe);
		returnTimeframe.setColumns(10);
		
		JComboBox<String> userType = new JComboBox<String>();
		userType.addItem("Male");
		userType.addItem("Female");
		userType.addItem("Any");
		userType.setBounds(645, 416, 242, 34);
		addProductPanel.add(userType);
		
		JButton btnAddProduct = new JButton("Add Product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer.valueOf(returnTimeframe.getText());
					Integer.valueOf(productCost.getText());
					Integer.valueOf(shippingCost.getText());
				}catch(Exception exp) {
					JOptionPane.showMessageDialog(null,"Product Cost, Shipping Cost and Return Time Frame can only be numbers");
					return;
				}
				if(productName.getText().length()==0 || productType.getText().length()==0 ||
						productSubType.getText().length()==0 || userType.getSelectedItem()==null) {
					JOptionPane.showMessageDialog(null, "All fields are required");
					return;
				}
				int status = new Product(productName.getText(), productType.getText(), productSubType.getText(), String.valueOf(userType.getSelectedItem()), Integer.valueOf(productCost.getText()), currentUser, Integer.valueOf(shippingCost.getText()), codFlag.isSelected(), 
						Integer.valueOf(returnTimeframe.getText()),"NEW").addProduct();
				if(status == 1) {
					int choice=JOptionPane.showConfirmDialog(null, "Product added! Add more?");
					if(choice==0) {
						//clear all fields, so that new product details can be entered
						productName.setText(null);
						productType.setText(null);
						productSubType.setText(null);
						codFlag.setSelected(false);
						shippingCost.setText(null);
						productCost.setText(null);
						returnTimeframe.setText(null);
					}else if(choice==1) {
						productName.setText(null);
						productType.setText(null);
						productSubType.setText(null);
						codFlag.setSelected(false);
						shippingCost.setText(null);
						productCost.setText(null);
						returnTimeframe.setText(null);
						userPanel.setVisible(true);
						addProductPanel.setVisible(false);
					}
				}
			}
		});
		btnAddProduct.setBounds(526, 772, 190, 45);
		addProductPanel.add(btnAddProduct);
		
		JButton button_2 = new JButton("<<Back");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addProductPanel.setVisible(false);
				userPanel.setVisible(true);
			}
		});
		button_2.setBounds(0, 0, 190, 45);
		addProductPanel.add(button_2);
		
		JLabel lblProductType = new JLabel("Product Type");
		lblProductType.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblProductType.setBounds(418, 262, 116, 32);
		addProductPanel.add(lblProductType);
		
		JLabel lblProductSubType = new JLabel("Product SubType");
		lblProductSubType.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblProductSubType.setBounds(418, 337, 180, 25);
		addProductPanel.add(lblProductSubType);
		
		productType = new JTextField();
		productType.setBounds(645, 262, 242, 34);
		addProductPanel.add(productType);
		productType.setColumns(10);
		
		productSubType = new JTextField();
		productSubType.setBounds(645, 337, 242, 34);
		addProductPanel.add(productSubType);
		productSubType.setColumns(10);
		
		JLabel lblUserType = new JLabel("User Type");
		lblUserType.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblUserType.setBounds(418, 413, 85, 25);
		addProductPanel.add(lblUserType);
		
		JLabel lblPleaseProvideDetails_1 = new JLabel("Please provide details:");
		lblPleaseProvideDetails_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblPleaseProvideDetails_1.setBounds(506, 97, 311, 45);
		addProductPanel.add(lblPleaseProvideDetails_1);
		
		
		
		
		JLabel lblOptionsToChoose = new JLabel("Options to choose from:");
		lblOptionsToChoose.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblOptionsToChoose.setBounds(506, 97, 311, 45);
		searchResultsPanel.add(lblOptionsToChoose);
		
		JButton button_5 = new JButton("<< Back");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchResultsPanel.remove(resultsSplitPane);
				currentProductSubType=null;
				searchResultsPanel.setVisible(false);
				btnNewButton.doClick();
//				filterPanel.setVisible(true);
			}
		});
		button_5.setBounds(0, 0, 190, 45);
		searchResultsPanel.add(button_5);
		
		JButton btnAddToCart = new JButton("Add to cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(searchResultsList.getSelectedIndex()<0) {
					JOptionPane.showMessageDialog(null,"Please select a product");
				}
				else if(searchResultsPanel.getComponentCount()==5) {
					JOptionPane.showMessageDialog(null,"Nothing to add");
				}
				else {
					String productId = searchResults[searchResultsList.getSelectedIndex()].productId;
					new Product().updateProductStatus(productId, "ADDED");
					new ShoppingCart(currentUser, productId).addToCart();
					JOptionPane.showMessageDialog(null,"Product added to cart");
					
					//refresh searchResultsList
					searchResults = new Product().searchProducts(currentProductUserType, currentProductType, currentProductSubType);
					if(searchResults.length==0) {
						JOptionPane.showMessageDialog(null,"Only product added to cart");
						searchResultsPanel.remove(resultsSplitPane);
						searchResultsPanel.revalidate();
						searchResultsPanel.repaint();
						btnNewButton_1.doClick();
					}else {
						searchResultsPanel.remove(resultsSplitPane);
						//display search results
						String[] productNames = new String[searchResults.length];
						int i=0;
						for(Product p:searchResults) {
							productNames[i++]=p.productName;
						}
						searchResultsList = new JList<String>(productNames);
						JScrollPane listScrollPane = new JScrollPane(searchResultsList);
						productInfoPanel = new JPanel();
						productInfoPanel.setLayout(new GridLayout(0, 1));
						JLabel productCost = new JLabel();
						JLabel shippingCost = new JLabel();
						JLabel CODFlag = new JLabel();
						JLabel returnFlag = new JLabel();
						productInfoPanel.add(productCost);
						productInfoPanel.add(shippingCost);
						productInfoPanel.add(CODFlag);
						productInfoPanel.add(returnFlag);
						resultsSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,listScrollPane,productInfoPanel);
						
						searchResultsList.addListSelectionListener(new ListSelectionListener() {						
							public void valueChanged(ListSelectionEvent e) {
								// TODO Auto-generated method stub
								if(searchResultsList.getSelectedIndices().length>0) {
									productCost.setText("Product Cost: "+searchResults[searchResultsList.getSelectedIndex()].productCost);
									shippingCost.setText("Shipping Cost: "+searchResults[searchResultsList.getSelectedIndex()].shippingCost);
									CODFlag.setText("COD Eligible: "+searchResults[searchResultsList.getSelectedIndex()].CODFlag);
									returnFlag.setText("Return Time Frame: "+searchResults[searchResultsList.getSelectedIndex()].returnTimeframe);
								}
							}
						});
						
						resultsSplitPane.setBounds(200, 150, 800, 600);
						resultsSplitPane.setDividerLocation(0.4);
						searchResultsPanel.add(resultsSplitPane);	
						searchResultsPanel.revalidate();
						searchResultsPanel.repaint();
					}
				}
			}
		});
		btnAddToCart.setBounds(254, 767, 190, 45);
		searchResultsPanel.add(btnAddToCart);
		
		btnNewButton_1 = new JButton("View Cart");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(shoppingCartPane!=null) {
					shoppingCartPanel.remove(shoppingCartPane);
					shoppingCartPanel.revalidate();
					shoppingCartPanel.repaint();
				}
				productsInCart = new ShoppingCart().getProductsInCart(currentUser);
				if(productsInCart.length == 0) {
					JOptionPane.showMessageDialog(null,"No items in cart");
					return;
				}
				searchResultsPanel.remove(resultsSplitPane);
				searchResultsPanel.setVisible(false);
				String[] productNames = new String[productsInCart.length];
				int index=0;
				for(Product p:productsInCart) {
					productNames[index++]=p.productName;
				}
				itemsInCartList=new JList<>(productNames);
				itemsInCartList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				JScrollPane listScrollPane = new JScrollPane(itemsInCartList);
				productInfoPanel = new JPanel();
				productInfoPanel.setLayout(new GridLayout(0, 1));
				JLabel productCost = new JLabel();
				JLabel shippingCost = new JLabel();
				JLabel CODFlag = new JLabel();
				JLabel returnFlag = new JLabel();
				productInfoPanel.add(productCost);
				productInfoPanel.add(shippingCost);
				productInfoPanel.add(CODFlag);
				productInfoPanel.add(returnFlag);
				shoppingCartPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,listScrollPane,productInfoPanel);
				
				itemsInCartList.addListSelectionListener(new ListSelectionListener() {						
					public void valueChanged(ListSelectionEvent e) {
						// TODO Auto-generated method stub
						if(itemsInCartList.getSelectedIndices().length>0) {
							productCost.setText("Product Cost: "+productsInCart[itemsInCartList.getSelectedIndex()].productCost);
							shippingCost.setText("Shipping Cost: "+productsInCart[itemsInCartList.getSelectedIndex()].shippingCost);
							CODFlag.setText("COD Eligible: "+productsInCart[itemsInCartList.getSelectedIndex()].CODFlag);
							returnFlag.setText("Return Time Frame: "+productsInCart[itemsInCartList.getSelectedIndex()].returnTimeframe);
						}
					}
				});
				
				shoppingCartPane.setBounds(200, 150, 800, 600);
				shoppingCartPane.setDividerLocation(0.4);
				shoppingCartPanel.add(shoppingCartPane);
				shoppingCartPanel.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(761, 767, 190, 45);
		searchResultsPanel.add(btnNewButton_1);
		
		JButton btnProceedToCheckout = new JButton("Proceed to Checkout");
		btnProceedToCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(shoppingCartPane!=null) {
					shoppingCartPanel.remove(shoppingCartPane);
					shoppingCartPanel.revalidate();
					shoppingCartPanel.repaint();
				}
				productsInCart = new ShoppingCart().getProductsInCart(currentUser);
				if(productsInCart.length == 0) {
					JOptionPane.showMessageDialog(null,"No items in cart");
					return;
				}
				searchResultsPanel.remove(resultsSplitPane);
				searchResultsPanel.setVisible(false);
				String[] productNames = new String[productsInCart.length];
				int index=0;
				for(Product p:productsInCart) {
					productNames[index++]=p.productName;
				}
				itemsInCartList=new JList<>(productNames);
				itemsInCartList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				JScrollPane listScrollPane = new JScrollPane(itemsInCartList);
				productInfoPanel = new JPanel();
				productInfoPanel.setLayout(new GridLayout(0, 1));
				JLabel productCost = new JLabel();
				JLabel shippingCost = new JLabel();
				JLabel CODFlag = new JLabel();
				JLabel returnFlag = new JLabel();
				productInfoPanel.add(productCost);
				productInfoPanel.add(shippingCost);
				productInfoPanel.add(CODFlag);
				productInfoPanel.add(returnFlag);
				shoppingCartPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,listScrollPane,productInfoPanel);
				
				itemsInCartList.addListSelectionListener(new ListSelectionListener() {						
					public void valueChanged(ListSelectionEvent e) {
						// TODO Auto-generated method stub
						if(itemsInCartList.getSelectedIndices().length>0) {
							productCost.setText("Product Cost: "+productsInCart[itemsInCartList.getSelectedIndex()].productCost);
							shippingCost.setText("Shipping Cost: "+productsInCart[itemsInCartList.getSelectedIndex()].shippingCost);
							CODFlag.setText("COD Eligible: "+productsInCart[itemsInCartList.getSelectedIndex()].CODFlag);
							returnFlag.setText("Return Time Frame: "+productsInCart[itemsInCartList.getSelectedIndex()].returnTimeframe);
						}
					}
				});
				
				shoppingCartPane.setBounds(200, 150, 800, 600);
				shoppingCartPane.setDividerLocation(0.4);
				shoppingCartPanel.add(shoppingCartPane);
				shoppingCartPanel.setVisible(true);
			}
		});
		btnProceedToCheckout.setBounds(500, 767, 190, 45);
		searchResultsPanel.add(btnProceedToCheckout);
		
		JButton button_7 = new JButton("<< Back");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateOrderStatusPanel.setVisible(false);
				adminPanel.setVisible(true);
			}
		});
		button_7.setBounds(0, 0, 190, 45);
		updateOrderStatusPanel.add(button_7);
		
		JLabel lblOrderId = new JLabel("Order ID");
		lblOrderId.setBounds(540, 176, 56, 16);
		updateOrderStatusPanel.add(lblOrderId);
		
		JComboBox<String> orderStatusComboBox = new JComboBox<String>();
		orderStatusComboBox.setBounds(540, 234, 184, 22);
		updateOrderStatusPanel.add(orderStatusComboBox);
		orderStatusComboBox.addItem("SHIPPED");
		orderStatusComboBox.addItem("COMPLETED");
		orderStatusComboBox.addItem("CANCELLED-REFUNDED");
		orderStatusComboBox.addItem("RETURN-REFUNDED");
		
		orderIdTf = new JTextField();
		orderIdTf.setBounds(596, 173, 128, 22);
		updateOrderStatusPanel.add(orderIdTf);
		orderIdTf.setColumns(10);
		
		JButton btnUpdateStatus = new JButton("Update Status");
		btnUpdateStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(orderIdTf.getText().length()==0)
					JOptionPane.showMessageDialog(null, "Order ID cannot be null");
				else {
					if(new OrderDetails().getOrderDetails(orderIdTf.getText())==null)
						JOptionPane.showMessageDialog(null, "No such Order ID found");
					else {
						new OrderDetails().updateOrderStatus(orderIdTf.getText(),orderStatusComboBox.getSelectedItem().toString());
						if(orderStatusComboBox.getSelectedItem().toString().equals("SHIPPED"))
							new OrderDetails().updateDateShipped(orderIdTf.getText());
						orderIdTf.setText("");
						int choice = JOptionPane.showConfirmDialog(null, "Order status changed! Are you done?");
						if(choice == 0) {
							updateOrderStatusPanel.setVisible(false);
							adminPanel.setVisible(true);
						}
					}
				}
			}
		});
		btnUpdateStatus.setBounds(554, 346, 127, 25);
		updateOrderStatusPanel.add(btnUpdateStatus);
		
	}
}
