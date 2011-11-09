 SET SCHEMA webshop;
-- Insert some productEntity categories
INSERT INTO ProductCategory (LOCAL_ID, GLOBAL_ID) VALUES
  ('books', 'book');
INSERT INTO ProductCategory (LOCAL_ID, GLOBAL_ID) VALUES
  ('Computers', 'device');
INSERT INTO ProductCategory (LOCAL_ID, GLOBAL_ID) VALUES
  ('Phones', 'device');
-- Insert some productEntity descriptions
INSERT INTO ProductCatalog
  (PRODUCTCATEGORY_IDREF,PRODUCTCATEGORYITEM_ID,PRODUCERNAME,NAME,
  PRICE,WEIGHT,QTYSTOCK,QTYLOCKED,QTYRESUPPLY,AVAILABILITYTHRESHOLD,DESCRIPTION)
  VALUES
  ('books','ISBN-0321200683','Addison-Wesley Professional',
   'Enterprise Integration Patterns: Designing, Building, and Deploying Messaging Solutions',
   47.99,null,8,0,5,2,
   'Utilizing years of practical experience, seasoned experts Gregor Hohpe and Bobby Woolf show how asynchronous messaging has proven to be the best strategy for enterprise integration success. However, building and deploying messaging solutions presents a number of problems for developers. Enterprise Integration Patterns provides an invaluable catalog of sixty-five patterns, with real-world solutions that demonstrate the formidable of messaging and help you to design effective messaging solutions for your enterprise.');


INSERT INTO ProductCatalog
  (PRODUCTCATEGORY_IDREF,PRODUCTCATEGORYITEM_ID,PRODUCERNAME,NAME,
  PRICE,WEIGHT,QTYSTOCK,QTYLOCKED,QTYRESUPPLY,AVAILABILITYTHRESHOLD,DESCRIPTION)
  VALUES
  ('books','ISBN-0131488740','Prentice Hall',
   'Web Services Platform Architecture: SOAP, WSDL, WS-Policy, WS-Addressing, WS-BPEL, WS-Reliable Messaging, and More',
   38.34,null,6,0,2,1,
   'Using today''s new Web services platform, you can build services that are secure, reliable, efficient at handling transactions, and well suited to your evolving service-oriented architecture. What''s more, you can do all that without compromising the simplicity or interoperability that made Web services so attractive. Now, for the first time, the experts who helped define and architect this platform show you exactly how to make the most of it.\nUnlike other books, Web Services Platform Architecture covers the entire platform. The authors illuminate every specification that''s ready for practical use, covering messaging, metadata, security, discovery, quality of service, business-process modeling, and more. Drawing on realistic examples and case studies, they present a powerfully coherent view of how all these specifications fit together—and how to combine them to solve real-world problems.'
   );

INSERT INTO ProductCatalog
  (PRODUCTCATEGORY_IDREF,PRODUCTCATEGORYITEM_ID,PRODUCERNAME,NAME,
  PRICE,WEIGHT,QTYSTOCK,QTYLOCKED,QTYRESUPPLY,AVAILABILITYTHRESHOLD,DESCRIPTION)
  VALUES
  ('Computers','V375006','DELL',
   'Dell Vostro 3750 V375006 Notebook 43,94 cm (17,3") Silver',
   949.00,2.8,10,0,8,3,
   'ProSupport and 2yr on-site NBD*43.94 cm (17.3 ") HD + (1600x900) display low-reflection\n'+
   'Processor: Intel ® Core TM i7-2670QM (4x 2.2 GHz)\n'+
   'RAM: 8 GB DDR3 RAM\n'+
   'Hard Drive: 750 GB SATA II\n'+
   'Graphics: NVIDIA ® GeForce TM GT 525M with 1GB VRAM\n'+
   'Operating System: Windows ® 7 Professional (64-bit).');

INSERT INTO ProductCatalog
  (PRODUCTCATEGORY_IDREF,PRODUCTCATEGORYITEM_ID,PRODUCERNAME,NAME,
  PRICE,WEIGHT,QTYSTOCK,QTYLOCKED,QTYRESUPPLY,AVAILABILITYTHRESHOLD,DESCRIPTION)
  VALUES
  ('Computers','MC503D / A','Apple',
   'Apple MacBook Air 33.78 cm',
   999.00,1.32,20,0,10,2,
   '33.78 cm (13.3 ") widescreen display with LED backlight\n'+
   'Supported resolutions: 1440 x 900 (native), 1280 x 800, 1152 x 720, 1024 x 640 and 800 x 500 pixels at 16:10 aspect ratio, 1024 x 768, 800 and 640 x 600 x 480 pixels with an aspect ratio of 4:3, 720 x 480 pixels at 3:2 aspect ratio\n'+
   'FaceTime camera\n'+
   'Bluetooth 2.1 + EDR\n'+
   'Full-size keyboard with 79 (ISO) keys, including 12 function keys and 4 arrow keys (inverted T arrangement as)\n'+
   'Multi-Touch trackpad for precise cursor control, scrolling supports dynamic, on-pinch, rotate, swipe, three-finger swipe, four-finger swipe, tap, double tap and drag feature\n'+
   'Up to 7 hours of wireless productivity.');

INSERT INTO ProductCatalog
  (PRODUCTCATEGORY_IDREF,PRODUCTCATEGORYITEM_ID,PRODUCERNAME,NAME,
  PRICE,WEIGHT,QTYSTOCK,QTYLOCKED,QTYRESUPPLY,AVAILABILITYTHRESHOLD,DESCRIPTION)
  VALUES
  ('Phones','ASIN-B0053FGCDG','Samsung',
   'Clear Smooth Durable TPU Skin with Argyle Texture Design Protector / Silicone Gel Skin Cover Case for HTC Inspire 4G Android Cell Phone ( AT&T )',
   17.99,null,12,0,3,1,
   'Made with the right demensions for your HTC Inspire 4G.\n'+
   'Has Snap On feature, making it easy to install.\n'+
   'Access the full features, such as the charger slot, volume buttons and front & back cameras.\n'+
   'Includes a USB Data Cable.\n'+
   'Includes Anti Glare Screen Protector Guard');

INSERT INTO ProductCatalog
  (PRODUCTCATEGORY_IDREF,PRODUCTCATEGORYITEM_ID,PRODUCERNAME,NAME,
  PRICE,WEIGHT,QTYSTOCK,QTYLOCKED,QTYRESUPPLY,AVAILABILITYTHRESHOLD,DESCRIPTION)
  VALUES
  ('Phones','ASIN-B004R8WDRO','Motorola',
   '5x Motorola ATRIX 4G MB860 Premium Clear LCD Screen Protector Cover Guard Shield Flim Kit',
   59.69,null,7,0,10,2,
   'Pre-cut to match screen shape, no cutting is required! Cover the full screen!\n'+
   'Shield and protect your screen from unwanted scratches\n'+
   'Anti-UV, filter out 99% of UV light from your screen or reflecting to your eyes\n'+
   'Reduce-Glare, reduce annoying surface glare under bright lights\n'+
   'Self-adhering, Leaves no sticky residue after removed!');

INSERT INTO Promotions
  (PRODUCT_IDREF,DISCOUNT,QTYMIN)
  VALUES
  ('1',0.1,2);

INSERT INTO Taxes
  (CATEGORY_IDREF, COUNTRYPREFIX, VAT)
 VALUES
  ('books', 'MD', 0);

INSERT INTO Taxes
  (CATEGORY_IDREF, COUNTRYPREFIX, VAT)
 VALUES
  ('Computers', 'MD', 0.15);


