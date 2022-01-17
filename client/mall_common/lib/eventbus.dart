library mall_api;

class EventBus {
  Map<String, Map<String, Null Function(String, dynamic)>> evPip = new Map();

  /// 订阅
  on(String client, String eventName, Null Function(String, dynamic) cb) {
    var subscriber = evPip[eventName];
    if (subscriber == null) {
      subscriber = new Map();
    }
    subscriber[client] = cb;

    evPip[eventName] = subscriber;
  }

  /// 取消订阅
  off(String client, String eventName) {
    //从事件列表删除 订阅客户
    var subscriber = evPip[eventName];
    subscriber.remove(client);
  }

  /// 触发
  fire(String client, String ev, dynamic payload) {
    Map<String, Function> subscriber = evPip[ev];
    for (final callback in subscriber.entries) {
      callback.value.call(client, payload);
    }
  }
}
