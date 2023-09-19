import 'package:flutter/material.dart';
import 'package:frontend/molecules/top_bar_sub.dart';
import 'package:frontend/molecules/vertical_list.dart';
import 'package:frontend/molecules/appbar.dart';

import '../models/product.dart';

class ProductFilteredPage extends StatelessWidget {
  List<Product> testList = [
    new Product(1, 'test product short', '', 1800),
    new Product(2, 'test product middle middle', '', 39900),
    new Product(3, 'test product long long long long long long long', '', 1498000),
    new Product(4, 'test product short', '', 1800),
    new Product(5, 'test product short', '', 1800),
    new Product(6, 'test product short', '', 1800),
    new Product(7, 'test product short', '', 1800),
    new Product(8, 'test product short', '', 1800),
    new Product(8, 'test product short', '', 1800),
    new Product(8, 'test product short', '', 1800),
    new Product(8, 'test product short', '', 1800),
    new Product(8, 'test product short', '', 1800),
    new Product(8, 'test product short', '', 1800),

  ];
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: TopBarSub(appBar: AppBar(),),// AppBar에 표시할 제목
        body: ListView(
            children: [
              Placeholder(),
              VerticalList(productList: testList)
            ]
        ),
      );
  }
}