library mall_api;

class MallApi {
  get(String path, {queryString: String}) {
    print("http get 请求");
  }

  post(String path, {body: dynamic}) {
    print("http post请求");
  }
}
