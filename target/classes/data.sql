INSERT INTO manufacturer (man_id, man_name, street, city, state, zip, email, phone) VALUES
	(1, "Monterray Bay Herb Co.", "241 Walker Street", "Watsonville", "CA", "95076", "support@herbco.com", "8317223400"),
	(2, "Tea Source", "2616 N. Cleveland Avenue", "Roseville", "MN", "55113", "office@teasource.com", "6517889971"),
	(3, "San Francisco Herb Co.", "250 14th Street", "San Francisco", "CA", "94103", "info@sanfranherbco.com", "8002274530");

INSERT INTO product (product_id, product_name, description, cost, stock, man_id) VALUES
	(1, "Chai Tea", "Chai Loose Leaf", 13.07, 100, 1),
	(2, "Black Current Tea", "Black Loose Leaf", 11.36, 250, 1),
	(3, "Jasmine Tea", "Green Loose Leaf Organic", 23.75, 100, 1),
	(4, "Red Dawn", "Black Loose Leaf", 48.64, 75, 2),
	(5, "Apple Pie", "Black Loose Leaf", 53.20, 125, 2),
	(6, "Cranberry Spice", "Herbal Loose Leaf", 39.52, 225, 2),
	(7, "Black Licorice", "Herbal Loose Leaf", 24.70, 75, 2),
	(8, "Abrosia Tea", "Black Loose Leaf", 10.40, 100, 2),
	(9, "Apricot Tea", "Black Loose Leaf", 9.55, 130, 3),
	(10, "Dragon Well", "Green Loose Leaf", 18.40, 130, 3),
	(11, "Gunpowder", "Green Loose Leaf", 8.20, 140, 3),
	(12, "Butterfly Pea Flowers", "Herbal Loose Leaf", 13.20, 80, 3),
	(13, "Lemon Myrtle Leaf", "Herbal Loose Leaf", 12.80, 70, 3);