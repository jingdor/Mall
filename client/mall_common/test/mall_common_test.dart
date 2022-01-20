import 'package:flutter_test/flutter_test.dart';
import 'package:mall_common/eventbus.dart';

void main() {
  test('测试eventbus', () {
    var eb = new EventBus();

    var callback = (source, payload) {
      print("触发者" + source);
      print("负载" + payload);
    };

    eb.on("test", "test", callback);

    eb.fire("test1", "test", "hello");
  });
}
