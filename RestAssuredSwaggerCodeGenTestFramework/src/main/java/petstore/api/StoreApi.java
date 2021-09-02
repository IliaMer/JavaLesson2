/*
 * Swagger Petstore
 * This is a sample server Petstore server.  You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).  For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * OpenAPI spec version: 1.0.5
 * Contact: apiteam@swagger.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package petstore.api;

import com.google.gson.reflect.TypeToken;
import petstore.model.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;

import java.lang.reflect.Type;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import petstore.JSON;

import static io.restassured.http.Method.*;

public class StoreApi {

    private RequestSpecBuilder reqSpec;

    private StoreApi(RequestSpecBuilder reqSpec) {
        this.reqSpec = reqSpec;
    }

    public static StoreApi store(RequestSpecBuilder reqSpec) {
        return new StoreApi(reqSpec);
    }


    public DeleteOrderOper deleteOrder() {
        return new DeleteOrderOper(reqSpec);
    }

    public GetInventoryOper getInventory() {
        return new GetInventoryOper(reqSpec);
    }

    public GetOrderByIdOper getOrderById() {
        return new GetOrderByIdOper(reqSpec);
    }

    public PlaceOrderOper placeOrder() {
        return new PlaceOrderOper(reqSpec);
    }

    /**
     * Customise request specification
     */
    public StoreApi reqSpec(Consumer<RequestSpecBuilder> consumer) {
        consumer.accept(reqSpec);
        return this;
    }

    /**
     * Delete purchase order by ID
     * For valid response try integer IDs with positive integer value. Negative or non-integer values will generate API errors
     *
     * @see #orderIdPath ID of the order that needs to be deleted (required)
     */
    public class DeleteOrderOper {

        public static final String REQ_URI = "/store/order/{orderId}";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public DeleteOrderOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public DeleteOrderOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * DELETE /store/order/{orderId}
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(DELETE, REQ_URI));
        }

        /**
         * @param orderId (Long) ID of the order that needs to be deleted (required)
         */
        public DeleteOrderOper orderIdPath(Object orderId) {
            reqSpec.addPathParam("orderId", orderId);
            return this;
        }

        /**
         * Customise request specification
         */
        public DeleteOrderOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public DeleteOrderOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * Returns pet inventories by status
     * Returns a map of status codes to quantities
     *
     * return Map<String, Integer>
     */
    public class GetInventoryOper {

        public static final String REQ_URI = "/store/inventory";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public GetInventoryOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public GetInventoryOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * GET /store/inventory
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(GET, REQ_URI));
        }

        /**
         * GET /store/inventory
         * @return Map<String, Integer>
         */
        public Map<String, Integer> executeAs(Function<Response, Response> handler) {
            Type type = new TypeToken<Map<String, Integer>>(){}.getType();
            return execute(handler).as(type);
        }

        /**
         * Customise request specification
         */
        public GetInventoryOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public GetInventoryOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * Find purchase order by ID
     * For valid response try integer IDs with value &gt;&#x3D; 1 and &lt;&#x3D; 10. Other values will generated exceptions
     *
     * @see #orderIdPath ID of pet that needs to be fetched (required)
     * return Order
     */
    public class GetOrderByIdOper {

        public static final String REQ_URI = "/store/order/{orderId}";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public GetOrderByIdOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public GetOrderByIdOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * GET /store/order/{orderId}
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(GET, REQ_URI));
        }

        /**
         * GET /store/order/{orderId}
         * @return Order
         */
        public Order executeAs(Function<Response, Response> handler) {
            Type type = new TypeToken<Order>(){}.getType();
            return execute(handler).as(type);
        }

        /**
         * @param orderId (Long) ID of pet that needs to be fetched (required)
         */
        public GetOrderByIdOper orderIdPath(Object orderId) {
            reqSpec.addPathParam("orderId", orderId);
            return this;
        }

        /**
         * Customise request specification
         */
        public GetOrderByIdOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public GetOrderByIdOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * Place an order for a pet
     *
     *
     * @see #body order placed for purchasing the pet (required)
     * return Order
     */
    public class PlaceOrderOper {

        public static final String REQ_URI = "/store/order";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public PlaceOrderOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setContentType("application/json");
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public PlaceOrderOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setContentType("application/json");
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * POST /store/order
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(POST, REQ_URI));
        }

        public Response execute() {
            return RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(POST, REQ_URI);
        }

        /**
         * POST /store/order
         * @return Order
         */
        public Order executeAs(Function<Response, Response> handler) {
            Type type = new TypeToken<Order>(){}.getType();
            return execute(handler).as(type);
        }

        /**
         * @param body (Order) order placed for purchasing the pet (required)
         */
        public PlaceOrderOper body(Order body) {
            reqSpec.setBody(body);
            return this;
        }

        /**
         * Customise request specification
         */
        public PlaceOrderOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public PlaceOrderOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
}