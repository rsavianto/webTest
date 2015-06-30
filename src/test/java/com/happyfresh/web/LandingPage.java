package com.happyfresh.web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LandingPage extends WebBaseTesting{
	
	@Test //Open HappyFresh Web
	public void JOY_001(){
		isHome();
		Assert.assertEquals("", driver.findElement(By.cssSelector("img.hf-brand-logo")).getText());
		Assert.assertEquals("Fresh groceries at your doorstep in the next hour.", driver.findElement(By.cssSelector("h1")).getText());
		Assert.assertEquals("", driver.findElement(By.cssSelector("img.hf-brand-logo")).getText());
	}
	
	@Test //Open HappyFresh Web
	public void JOY_002(){
		Assert.assertEquals("Change", driver.findElement(By.id("country-dropdown")).getText());
		driver.findElement(By.id("country-dropdown")).click();
		isWait(10);
		Assert.assertEquals("Change", driver.findElement(By.cssSelector("span.link")).getText());
		driver.findElement(By.cssSelector("span.link")).click();
		isWait(10);
		driver.findElement(By.id("country-dropdown")).click();
		driver.findElement(By.linkText("Indonesia")).click();
		Assert.assertTrue(driver.findElement(By.id("area-country")).getText().matches("^[\\s\\S]*Indonesia[\\s\\S]*$"));
		driver.findElement(By.id("country-dropdown")).click();
		driver.findElement(By.linkText("Malaysia")).click();
		Assert.assertTrue(driver.findElement(By.id("area-country")).getText().matches("^[\\s\\S]*Malaysia[\\s\\S]*$"));
		driver.findElement(By.id("country-dropdown")).click();
		driver.findElement(By.linkText("Indonesia")).click();
		driver.findElement(By.name("Log In")).click();
		//JavascriptExecutor jse = (JavascriptExecutor)driver; 
		//jse.executeScript("javascript:window.scrollBy(0,250)", "");
		//jse.executeScript("scroll(0, 250);");
		//((JavascriptExecutor)driver).executeScript("scroll(250, 0);");
		//jse.executeScript("javascript:window.scrollBy(250,500)", "");
	}
	
	@Test //Open HappyFresh Web
	public void JOY_003(){
		new Select(driver.findElement(By.id("area-country"))).selectByVisibleText("Indonesia");
		isWait(10);
		new Select(driver.findElement(By.id("area-city"))).selectByVisibleText("Jakarta Selatan");
		isWait(10);
		//Assert.assertEquals("Cempaka Putih Barat", driver.findElement(By.cssSelector("div.Select-placeholder")).getText());

		driver.findElement(By.cssSelector("button.btn-start-shopping")).click();
		//driver.findElement(By.cssSelector("a > strong")).click();
	}

	
	/*@Test
	public void JOY_429(){
		element = driver.findElement(By.name("taxon-2"));
		elementCrossOver(element);
		isWait(100);
		Assert.assertEquals(driver.findElement(By.linkText("All Fresh Produce")).getText(), "All Fresh Produce","List of sub categories All Fresh Produce not found");
		Assert.assertEquals(driver.findElement(By.linkText("Fresh Fruits")).getText(), "Fresh Fruits","List of sub categories Fresh Fruits not found");
		Assert.assertEquals(driver.findElement(By.linkText("Fresh Vegetables")).getText(), "Fresh Vegetables","List of sub categories Fresh Vegetables not found");
		Assert.assertEquals(driver.findElement(By.linkText("Fresh Herbs")).getText(), "Fresh Herbs","List of sub categories Fresh Herbs not found");
		Assert.assertEquals(driver.findElement(By.linkText("Packaged Vegetables & Fruits")).getText(), "Packaged Vegetables & Fruits","List of sub categories Packaged Vegetables & Fruits not found");		
		
		element = driver.findElement(By.name("taxon-7"));
		elementCrossOver(element);
		isWait(100);
		Assert.assertEquals(driver.findElement(By.linkText("All Meat & Seafood")).getText(), "All Meat & Seafood","List of sub categories All Meat & Seafood not found");
		Assert.assertEquals(driver.findElement(By.linkText("Meat Counter")).getText(), "Meat Counter","List of sub categories Meat Counter not found");
		Assert.assertEquals(driver.findElement(By.linkText("Poultry Counter")).getText(), "Poultry Counter","List of sub categories Poultry Counter not found");
		Assert.assertEquals(driver.findElement(By.linkText("Seafood Counter")).getText(), "Seafood Counter","List of sub categories Seafood Counter not found");
		//Assert.assertEquals(driver.findElement(By.linkText("Packaged Meat & Seafood")).getText(), "Packaged Meat & Seafood","List of sub categories Packaged Meat & Seafood not found");
		
		element = driver.findElement(By.name("taxon-12"));
		elementCrossOver(element);
		isWait(100);
		Assert.assertEquals(driver.findElement(By.linkText("All Non-halal")).getText(), "All Non-halal","List of sub categories All Non-halal not found");
		Assert.assertEquals(driver.findElement(By.linkText("Hot Dogs, Ham, Bacon & Sausage")).getText(), "Hot Dogs, Ham, Bacon & Sausage","List of sub categories Hot Dogs, Ham, Bacon & Sausage not found");
		
		element = driver.findElement(By.name("taxon-13"));
		elementCrossOver(element);
		isWait(100);
		Assert.assertEquals(driver.findElement(By.linkText("All Deli")).getText(), "All Deli","List of sub categories All Deli not found");
		//Assert.assertEquals(driver.findElement(By.linkText("Lunch Meat")).getText(), "Lunch Meat","List of sub categories Lunch Meat not found");
		Assert.assertEquals(driver.findElement(By.linkText("Specialty Cheeses")).getText(), "Specialty Cheeses","List of sub categories Specialty Cheeses not found");
		//Assert.assertEquals(driver.findElement(By.linkText("Prepared Meals")).getText(), "Prepared Meals","List of sub categories Prepared Meals not found");
		//Assert.assertEquals(driver.findElement(By.linkText("Fresh Dips & Tapenades")).getText(), "Fresh Dips & Tapenades","List of sub categories Fresh Dips & Tapenades not found");		
		Assert.assertEquals(driver.findElement(By.linkText("Tofu & Meat Alternatives")).getText(), "Tofu & Meat Alternatives","List of sub categories Tofu & Meat Alternatives not found");
		
		element = driver.findElement(By.name("taxon-19"));
		elementCrossOver(element);
		isWait(100);
		Assert.assertEquals(driver.findElement(By.linkText("All Bakery")).getText(), "All Bakery","List of sub categories All Bakery not found");
		Assert.assertEquals(driver.findElement(By.linkText("Bread")).getText(), "Bread","List of sub categories Bread not found");
		Assert.assertEquals(driver.findElement(By.linkText("Tortillas & Flat Bread")).getText(), "Tortillas & Flat Bread","List of sub categories Tortillas & Flat Bread not found");
		Assert.assertEquals(driver.findElement(By.linkText("Bun & Rolls")).getText(), "Bun & Rolls","List of sub categories Bun & Rolls not found");
		Assert.assertEquals(driver.findElement(By.linkText("Bakery Desserts")).getText(), "Bakery Desserts","List of sub categories Bakery Desserts not found");
		
		element = driver.findElement(By.name("taxon-24"));
		elementCrossOver(element);
		isWait(100);
		Assert.assertEquals(driver.findElement(By.linkText("All Dairy")).getText(), "All Dairy","List of sub categories All Dairy not found");
		Assert.assertEquals(driver.findElement(By.linkText("Milk")).getText(), "Milk","List of sub categories Milk not found");
		Assert.assertEquals(driver.findElement(By.linkText("Cream")).getText(), "Cream","List of sub categories Cream not found");
		Assert.assertEquals(driver.findElement(By.linkText("Eggs")).getText(), "Eggs","List of sub categories Eggs not found");
		Assert.assertEquals(driver.findElement(By.linkText("Packaged Cheese")).getText(), "Packaged Cheese","List of sub categories Packaged Cheese not found");		
		Assert.assertEquals(driver.findElement(By.linkText("Yogurt")).getText(), "Yogurt","List of sub categories Yogurt not found");
		Assert.assertEquals(driver.findElement(By.linkText("Soy & lactose-free")).getText(), "Soy & lactose-free","List of sub categories Soy & lactose-free not found");
		Assert.assertEquals(driver.findElement(By.linkText("Refrigerated Pudding & Desserts")).getText(), "Refrigerated Pudding & Desserts","List of sub categories Refrigerated Pudding & Desserts not found");
		Assert.assertEquals(driver.findElement(By.linkText("Butter")).getText(), "Butter","List of sub categories Butter not found");
		Assert.assertEquals(driver.findElement(By.linkText("Other Creams & Cheeses")).getText(), "Other Creams & Cheeses","List of sub categories Other Creams & Cheeses not found");
		
		element = driver.findElement(By.name("taxon-34"));
		elementCrossOver(element);
		isWait(150);
		Assert.assertEquals(driver.findElement(By.linkText("All Dry & Canned Goods")).getText(), "All Dry & Canned Goods","List of sub categories All Dry & Canned Goods not found");
		Assert.assertEquals(driver.findElement(By.linkText("Canned Fruit & Applesauce")).getText(), "Canned Fruit & Applesauce","List of sub categories Canned Fruit & Applesauce not found");
		Assert.assertEquals(driver.findElement(By.linkText("Canned & Jarred Vegetables")).getText(), "Canned & Jarred Vegetables","List of sub categories Canned & Jarred Vegetables not found");
		Assert.assertEquals(driver.findElement(By.linkText("Canned Meals & Beans")).getText(), "Canned Meals & Beans","List of sub categories Canned Meals & Beans not found");
		Assert.assertEquals(driver.findElement(By.linkText("Canned Meat & Seafood")).getText(), "Canned Meat & Seafood","List of sub categories Canned Meat & Seafood not found");		
		Assert.assertEquals(driver.findElement(By.linkText("Soup, Broth & Bouillon")).getText(), "Soup, Broth & Bouillon","List of sub categories Soup, Broth & Bouillon not found");
		//scrollTo(10);
		//Assert.assertEquals(driver.findElement(By.linkText("Soup, Broth & Bouillon")).getText(), "Soy & lactose-free","List of sub categories Soy & lactose-free not found");
		Assert.assertEquals(driver.findElement(By.linkText("Dry Pasta")).getText(), "Dry Pasta","List of sub categories Refrigerated Dry Pasta not found");
		//Assert.assertEquals(driver.findElement(By.linkText("Fresh Pasta")).getText(), "Fresh Pasta","List of sub categories Fresh Pasta not found");
		Assert.assertEquals(driver.findElement(By.linkText("Pasta Sauce")).getText(), "Pasta Sauce","List of sub categories Pasta Sauce not found");
		Assert.assertEquals(driver.findElement(By.linkText("Instant Foods")).getText(), "Instant Foods","List of sub categories Instant Foods not found");
		Assert.assertEquals(driver.findElement(By.linkText("Grains, Rice & Dried Goods")).getText(), "Grains, Rice & Dried Goods","List of sub categories Grains, Rice & Dried Goods not found");
		Assert.assertEquals(driver.findElement(By.linkText("Cereal & Granola")).getText(), "Cereal & Granola","List of sub categories Cereal & Granola not found");
		//Assert.assertEquals(driver.findElement(By.linkText("Bulk")).getText(), "Bulk","List of sub categories Bulk not found");
		
		element = driver.findElement(By.name("taxon-48"));
		elementCrossOver(element);
		isWait(200);
		Assert.assertEquals(driver.findElement(By.linkText("All Pantry")).getText(), "All Pantry","List of sub categories All Pantry not found");
		Assert.assertEquals(driver.findElement(By.linkText("Condiments")).getText(), "Condiments","List of sub categories Condiments not found");
		Assert.assertEquals(driver.findElement(By.linkText("Honeys, Syrups & Nectars")).getText(), "Honeys, Syrups & Nectars","List of sub categories Honeys, Syrups & Nectars not found");
		Assert.assertEquals(driver.findElement(By.linkText("Spices & Seasonings")).getText(), "Spices & Seasonings","List of sub categories Spices & Seasonings not found");
		Assert.assertEquals(driver.findElement(By.linkText("Spreads")).getText(), "Spreads","List of sub categories Spreads not found");		
		Assert.assertEquals(driver.findElement(By.linkText("Salad Dressing & Toppings")).getText(), "Salad Dressing & Toppings","List of sub categories Salad Dressing & Toppings not found");
		Assert.assertEquals(driver.findElement(By.linkText("Oils & Vinegars")).getText(), "Oils & Vinegars","List of sub categories Oils & Vinegars not found");
		Assert.assertEquals(driver.findElement(By.linkText("Pickled Goods & Olives")).getText(), "Pickled Goods & Olives","List of sub categories Pickled Goods & Olives not found");
		Assert.assertEquals(driver.findElement(By.linkText("Marinades & Meat Preparation")).getText(), "Marinades & Meat Preparation","List of sub categories Marinades & Meat Preparation not found");
		Assert.assertEquals(driver.findElement(By.linkText("Preserved Dips & Spreads")).getText(), "Preserved Dips & Spreads","List of sub categories Preserved Dips & Spreads not found");
		Assert.assertEquals(driver.findElement(By.linkText("Doughs, Gelatins & Bake Mixes")).getText(), "Doughs, Gelatins & Bake Mixes","List of sub categories Doughs, Gelatins & Bake Mixes not found");
		Assert.assertEquals(driver.findElement(By.linkText("Baking Ingredients")).getText(), "Baking Ingredients","List of sub categories Baking Ingredients not found");
		Assert.assertEquals(driver.findElement(By.linkText("Baking Supplies & Decor")).getText(), "Baking Supplies & Decor","List of sub categories Baking Supplies & Decor not found");
		
		element = driver.findElement(By.name("taxon-53"));
		elementCrossOver(element);
		isWait(100);
		Assert.assertEquals(driver.findElement(By.linkText("All Beverages")).getText(), "All Beverages","List of sub categories All Beverages not found");
		Assert.assertEquals(driver.findElement(By.linkText("Tea")).getText(), "Tea","List of sub categories Tea not found");
		Assert.assertEquals(driver.findElement(By.linkText("Juices & Health Drinks")).getText(), "Juices & Health Drinks","List of sub categories Juices & Health Drinks not found");
		Assert.assertEquals(driver.findElement(By.linkText("Coffee")).getText(), "Coffee","List of sub categories Coffee not found");
		Assert.assertEquals(driver.findElement(By.linkText("Sport & Soft Drinks")).getText(), "Sport & Soft Drinks","List of sub categories Sport & Soft Drinks not found");
		Assert.assertEquals(driver.findElement(By.linkText("Water, Seltzer & Sparkling Water")).getText(), "Water, Seltzer & Sparkling Water","List of sub categories Water, Seltzer & Sparkling Water not found");
		Assert.assertEquals(driver.findElement(By.linkText("Cocoa & Drink Mixes")).getText(), "Cocoa & Drink Mixes","List of sub categories Cocoa & Drink Mixes not found");
		
		element = driver.findElement(By.name("taxon-60"));
		elementCrossOver(element);
		isWait(100);
		Assert.assertEquals(driver.findElement(By.linkText("All Snacks")).getText(), "All Snacks","List of sub categories All Snacks not found");
		Assert.assertEquals(driver.findElement(By.linkText("Candy & Chocolate")).getText(), "Candy & Chocolate","List of sub categories Candy & Chocolate not found");
		Assert.assertEquals(driver.findElement(By.linkText("Chips & Pretzels")).getText(), "Chips & Pretzels","List of sub categories Chips & Pretzels not found");
		Assert.assertEquals(driver.findElement(By.linkText("Cookies & Cakes")).getText(), "Cookies & Cakes","List of sub categories Cookies & Cakes not found");
		Assert.assertEquals(driver.findElement(By.linkText("Crackers")).getText(), "Crackers","List of sub categories Crackers not found");
		Assert.assertEquals(driver.findElement(By.linkText("Energy & Granola Bars")).getText(), "Energy & Granola Bars","List of sub categories Energy & Granola Bars not found");
		Assert.assertEquals(driver.findElement(By.linkText("Nuts, Seeds & Dried Snacks")).getText(), "Nuts, Seeds & Dried Snacks","List of sub categories Nuts, Seeds & Dried Snacks not found");
		Assert.assertEquals(driver.findElement(By.linkText("Trail Mix & Snack Mix")).getText(), "Trail Mix & Snack Mix","List of sub categories Trail Mix & Snack Mix not found");
		Assert.assertEquals(driver.findElement(By.linkText("Mint & Gum")).getText(), "Mint & Gum","List of sub categories Mint & Gum not found");
		Assert.assertEquals(driver.findElement(By.linkText("Nutrition Bars & Pastries")).getText(), "Nutrition Bars & Pastries","List of sub categories Nutrition Bars & Pastries not found");
		
		element = driver.findElement(By.name("taxon-70"));
		elementCrossOver(element);
		isWait(100);
		Assert.assertEquals(driver.findElement(By.linkText("All Frozen")).getText(), "All Frozen","List of sub categories All Frozen not found");
		Assert.assertEquals(driver.findElement(By.linkText("Frozen Appetizers & Sides")).getText(), "Frozen Appetizers & Sides","List of sub categories Frozen Appetizers & Sides not found");
		Assert.assertEquals(driver.findElement(By.linkText("Frozen Meals")).getText(), "Frozen Meals","List of sub categories Frozen Meals not found");
		//Assert.assertEquals(driver.findElement(By.linkText("Frozen Meats & Seafood")).getText(), "Frozen Meats & Seafood","List of sub categories Frozen Meats & Seafood not found");
		Assert.assertEquals(driver.findElement(By.linkText("Frozen Breads & Doughs")).getText(), "Frozen Breads & Doughs","List of sub categories Frozen Breads & Doughs not found");
		Assert.assertEquals(driver.findElement(By.linkText("Frozen Produce")).getText(), "Frozen Produce","List of sub categories Frozen Produce not found");
		Assert.assertEquals(driver.findElement(By.linkText("Frozen Vegetarian")).getText(), "Frozen Vegetarian","List of sub categories Frozen Vegetarian not found");
		Assert.assertEquals(driver.findElement(By.linkText("Frozen Dessert")).getText(), "Frozen Dessert","List of sub categories Frozen Dessert not found");
		Assert.assertEquals(driver.findElement(By.linkText("Ice Cream & Ice")).getText(), "Ice Cream & Ice","List of sub categories Ice Cream & Ice not found");
		
		element = driver.findElement(By.name("taxon-79"));
		elementCrossOver(element);
		isWait(100);
		Assert.assertEquals(driver.findElement(By.linkText("All Health & Beauty")).getText(), "All Health & Beauty","List of sub categories All Health & Beauty not found");
		Assert.assertEquals(driver.findElement(By.linkText("Facial Care")).getText(), "Facial Care","List of sub categories Facial Care not found");
		Assert.assertEquals(driver.findElement(By.linkText("Body Care")).getText(), "Body Care","List of sub categories Body Care not found");
		Assert.assertEquals(driver.findElement(By.linkText("Oral Hygiene")).getText(), "Oral Hygiene","List of sub categories Oral Hygiene not found");
		Assert.assertEquals(driver.findElement(By.linkText("Feminine Care")).getText(), "Feminine Care","List of sub categories Feminine Care not found");
		Assert.assertEquals(driver.findElement(By.linkText("First Aid & Health Care")).getText(), "First Aid & Health Care","List of sub categories First Aid & Health Care not found");
		Assert.assertEquals(driver.findElement(By.linkText("Beauty")).getText(), "Beauty","List of sub categories Beauty not found");
		Assert.assertEquals(driver.findElement(By.linkText("Vitamins & Supplements")).getText(), "Vitamins & Supplements","List of sub categories Vitamins & Supplements not found");
		Assert.assertEquals(driver.findElement(By.linkText("Hair Care")).getText(), "Hair Care","List of sub categories Hair Care not found");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver; 
		jse.executeScript("window.scrollBy(0,250)", "");
		element = driver.findElement(By.name("taxon-88"));
		elementCrossOver(element);
		isWait(100);
		Assert.assertEquals(driver.findElement(By.linkText("All Babies")).getText(), "All Babies","List of sub categories All Babies not found");
		Assert.assertEquals(driver.findElement(By.linkText("Baby Bath & Body Care")).getText(), "Baby Bath & Body Care","List of sub categories Baby Bath & Body Care not found");
		Assert.assertEquals(driver.findElement(By.linkText("Baby Food & Formula")).getText(), "Baby Food & Formula","List of sub categories Baby Food & Formula not found");
		Assert.assertEquals(driver.findElement(By.linkText("Diapers & Wipes")).getText(), "Diapers & Wipes","List of sub categories Diapers & Wipes not found");
		Assert.assertEquals(driver.findElement(By.linkText("Baby First Aids & Vitamins")).getText(), "Baby First Aids & Vitamins","List of sub categories Baby First Aids & Vitamins not found");
		
		element = driver.findElement(By.name("taxon-93"));
		elementCrossOver(element);
		isWait(50);
		Assert.assertEquals(driver.findElement(By.linkText("All Pets")).getText(), "All Pets","List of sub categories All Pets not found");
		Assert.assertEquals(driver.findElement(By.linkText("Cat Food & Care")).getText(), "Cat Food & Care","List of sub categories Cat Food & Care not found");
		Assert.assertEquals(driver.findElement(By.linkText("Dog Food & Care")).getText(), "Dog Food & Care","List of sub categories Dog Food & Care not found");
		
		element = driver.findElement(By.name("taxon-96"));
		elementCrossOver(element);
		isWait(100);
		Assert.assertEquals(driver.findElement(By.linkText("All Household")).getText(), "All Household","List of sub categories All Household not found");
		Assert.assertEquals(driver.findElement(By.linkText("Cleaning")).getText(), "Cleaning","List of sub categories Cleaning not found");
		Assert.assertEquals(driver.findElement(By.linkText("Food Storage & Party")).getText(), "Food Storage & Party","List of sub categories Food Storage & Party not found");
		Assert.assertEquals(driver.findElement(By.linkText("Kitchen Supplies")).getText(), "Kitchen Supplies","List of sub categories Kitchen Supplies not found");
		Assert.assertEquals(driver.findElement(By.linkText("Laundry")).getText(), "Laundry","List of sub categories Laundry not found");
		Assert.assertEquals(driver.findElement(By.linkText("Trash Bags & Liners")).getText(), "Trash Bags & Liners","List of sub categories Trash Bags & Liners not found");
		Assert.assertEquals(driver.findElement(By.linkText("Others")).getText(), "Others","List of sub categories Others not found");
		
		element = driver.findElement(By.name("taxon-103"));
		elementCrossOver(element);
		isWait(100);
		Assert.assertEquals(driver.findElement(By.linkText("All Alcohol & Tobacco")).getText(), "All Alcohol & Tobacco","List of sub categories All Alcohol & Tobacco not found");
		Assert.assertEquals(driver.findElement(By.linkText("Beer")).getText(), "Beer","List of sub categories Beer not found");
		Assert.assertEquals(driver.findElement(By.linkText("Wine")).getText(), "Wine","List of sub categories Wine not found");
		Assert.assertEquals(driver.findElement(By.linkText("Liquor & Spirits")).getText(), "Liquor & Spirits","List of sub categories Liquor & Spirits not found");
		Assert.assertEquals(driver.findElement(By.linkText("Cigarettes")).getText(), "Cigarettes","List of sub categories Cigarettes not found");
		//Assert.assertEquals(driver.findElement(By.linkText("Other Tobacco")).getText(), "Other Tobacco","List of sub categories Other Tobacco not found");
		((JavascriptExecutor)driver).executeScript("scroll(250, 0);");
	}
	
	@Test
	public void JOY_515(){
		//JavascriptExecutor jse = (JavascriptExecutor)driver; 
		//jse.executeScript("window.scrollBy(0,0)", "");
		//((JavascriptExecutor)driver).executeScript("scroll(250, 0);");
		isHome();
		isWait(100);
		element = driver.findElement(By.name("taxon-2"));
		elementCrossOver(element);
		element.click();
		Assert.assertEquals(driver.findElement(By.cssSelector("h4.hf-category-name > span")).getText(),"Fresh Fruits");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='hf']/div/div/div/section[2]/div[2]/div[2]/header/h4/span")).getText(), "Fresh Vegetables");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='hf']/div/div/div/section[2]/div[2]/div[3]/header/h4/span")).getText(), "Fresh Herbs");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='hf']/div/div/div/section[2]/div[2]/div[4]/header/h4/span")).getText(), "Packaged Vegetables & Fruits");
		
		driver.findElement(By.name("taxon-7")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("h4.hf-category-name > span")).getText(), "Meat Counter","List of sub categories Meat Counter not found");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='hf']/div/div/div/section[2]/div[2]/div[2]/header/h4/span")).getText(), "Poultry Counter","List of sub categories Poultry Counter not found");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='hf']/div/div/div/section[2]/div[2]/div[3]/header/h4/span")).getText(), "Seafood Counter","List of sub categories Seafood Counter not found");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='hf']/div/div/div/section[2]/div[2]/div[4]/header/h4/span")).getText(), "Packaged Meat & Seafood","List of sub categories Packaged Meat & Seafood not found");
		
	}
	
	@Test
	public void JOY_505(){
		isHome();
		scrollingToBottomofAPage();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.hf-one-col.st > h5")).getText(), "HELP");
		Assert.assertEquals("Contact Us", driver.findElement(By.linkText("Contact Us")).getText());
		Assert.assertEquals("About", driver.findElement(By.xpath("//div[@id='hf']/footer/div/div/div/div[2]/nav/div[2]/h5")).getText());
		Assert.assertEquals("Careers", driver.findElement(By.xpath("//div[@id='hf']/footer/div/div/div/div[2]/nav/div[2]/ol/li")).getText());
		Assert.assertEquals("", driver.findElement(By.cssSelector("img[alt=\"App Store\"]")).getText());
		Assert.assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Play Store\"]")).getText());


		//driver.findElement(By.xpath("//div[@id='hf']/div/div/aside/nav/ol/li/div/ol/li/a/span[2]")).click();
		//driver.findElement(By.linkText("Poultry Counter")).click();
		//Assert.assertEquals("Meat & Seafood", driver.findElement(By.cssSelector("h4.hf-category-name > span")).getText());
	}
	
	@Test
	public void JOY_506(){
		//driver.findElement(By.cssSelector("button.hf-nav-signup.open-popup")).click();
		driver.findElement(By.xpath("//div[@id='hf']/header/div/div/div[2]/div[3]/div/div[2]/div/button[1]")).click();
		driver.findElement(By.cssSelector("input.half")).clear();
		driver.findElement(By.cssSelector("input.half")).sendKeys("Budi");
		driver.findElement(By.cssSelector("input.half.side-margin")).clear();
		driver.findElement(By.cssSelector("input.half.side-margin")).sendKeys("Saya");
		driver.findElement(By.cssSelector("form > input.hf-search-input")).clear();
		driver.findElement(By.cssSelector("form > input.hf-search-input")).sendKeys("a@b.com");
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		Assert.assertEquals("Password minimum 6 characters", driver.findElement(By.cssSelector("div.alert.alert-danger")).getText());

		driver.findElement(By.cssSelector("input.hf-search-input")).clear();
		driver.findElement(By.cssSelector("input.hf-search-input")).sendKeys("Egg");
		driver.findElement(By.cssSelector("input.hf-search-input")).clear();

	}
*/
}
