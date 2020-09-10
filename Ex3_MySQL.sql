/*- Viết câu lệnh để tạo 2 bảng Danh mục ( Category), Sản phẩm ( Product)
  + Danh mục: ID danh mục (tăng dần), tên, ngày tạo, ngày sửa, mô tả
  + Sản phẩm: ID sản phẩm (tăng dần), tên, đường dẫn ảnh sản phẩm, giá sản phẩm, số lượng sản phẩm, Số lượng bán , mô tả sản phẩm, ID danh mục ( 1 sản phẩm thuộc 1 danh mục)
*/
CREATE DATABASE Ex3_MySQL;
USE Ex3_MySQL;

create table `Category`(
	`IDCategory` int(11) not null auto_increment,
    `Name` varchar(50) character set utf8 collate utf8_general_ci not null,
    `Date_create` datetime default null,
    `Date_fix` datetime default null,
    `Description` varchar(1000) character set utf8 collate utf8_general_ci default null,
    primary key (`IDCategory`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

create table `Product`(
	`IDProduct` int(11) not null auto_increment,
    `Name` varchar(50) character set utf8 collate utf8_general_ci not null,
    `Product_image_path` varchar(50) not null,
    `Price` int(15) not null,
    `Count_product` int(10) not null,
    `Count_sell` int(10) not null,
    `Description` varchar(1000) character set utf8 collate utf8_general_ci default null,
    `IDCategory` int(11) not null,
    primary key (`IDProduct`),
    constraint `fk_Product_Category` foreign key (`IDCategory`) references `Category`(`IDCategory`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

INSERT INTO `ex3_mysql`.`product` (`IDProduct`, `Name`, `Product_image_path`, `Price`, `Count_product`, `Count_sell`, `Description`, `IDCategory`) VALUES ('14', 'Tivi', '#', '10000000', '300', '100', 'Smart tive', '11');
INSERT INTO `ex3_mysql`.`product` (`IDProduct`, `Name`, `Product_image_path`, `Price`, `Count_product`, `Count_sell`, `Description`, `IDCategory`) VALUES ('15', 'laptop', '#', '20000000', '200', '150', 'laptop win', '11');
INSERT INTO `ex3_mysql`.`product` (`IDProduct`, `Name`, `Product_image_path`, `Price`, `Count_product`, `Count_sell`, `Description`, `IDCategory`) VALUES ('13', 'Smartphone', '#', '10000000', '200', '150', 'Smartphone', '11');
INSERT INTO `ex3_mysql`.`product` (`IDProduct`, `Name`, `Product_image_path`, `Price`, `Count_product`, `Count_sell`, `Description`, `IDCategory`) VALUES ('12', 'Macbook', '#', '30000000', '200', '150', 'mac apple', '10');
INSERT INTO `ex3_mysql`.`product` (`IDProduct`, `Name`, `Product_image_path`, `Price`, `Count_product`, `Count_sell`, `Description`, `IDCategory`) VALUES ('11', 'Smartphone', '#', '40000000', '200', '150', 'iphone', '10');


INSERT INTO `ex3_mysql`.`category` (`IDCategory`, `Name`, `Date_create`, `Date_fix`, `Description`) VALUES ('12', 'Apple', '2020/4/9', '2020/6/10', 'Congty apple');
INSERT INTO `ex3_mysql`.`category` (`IDCategory`, `Name`, `Date_create`, `Date_fix`, `Description`) VALUES ('12', 'Samsung', '2020/3/9', '2020/5/10', 'Congty samsung');
INSERT INTO `ex3_mysql`.`category` (`IDCategory`, `Name`, `Date_create`, `Date_fix`, `Description`) VALUES ('12', 'LG', '2020/2/9', '2020/5/10', 'Congty LG');



use ex3_mysql;

/*- Viết câu lệnh để lọc các sản phẩm có chứa từ 'Điện thoại' và thuộc danh mục có tên 'Apple'.*/
SELECT product.* 
FROM category, product
WHERE category.IDCategory=product.IDCategory and category.Name="Apple" and product.Name="Smart phone";

/*- Viết câu lệnh đếm số lượng sản phẩm trong mỗi danh mục, sắp xếp theo số lượng giảm dần.*/
select category.*, count(category.IDCategory) as "Count"
from category, product
where category.IDCategory=product.IDCategory 
group by category.IDCategory
/*having count(category.IDCategory)*/
order by count(category.IDCategory) desc;

/*- Viết câu lệnh lấy Top 10 sản phẩm có số lượng bán nhiều nhất.*/
select product.*
from product
order by Count_sell desc
limit 10;



