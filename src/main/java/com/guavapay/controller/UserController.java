package com.guavapay.controller;

import com.guavapay.integration.client.CourierOrderClient;
import com.guavapay.model.dto.CourierOrderDto;
import com.guavapay.model.dto.CourierOrderHistoryDto;
import com.guavapay.model.request.CourierOrderChangeRequest;
import com.guavapay.model.request.CourierOrderFilter;
import com.guavapay.model.request.CourierOrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "courier/order")
public class UserController {

    private final CourierOrderClient courierOrderClient;

    @PostMapping(value = "/create", consumes = {"application/json"}, produces = {"application/json"})
    public CourierOrderDto createCourierOrder(@Valid @RequestBody CourierOrderRequest courierOrderRequest) {
        return courierOrderClient.orderCourier(courierOrderRequest);
    }

    @PostMapping(value = "/change", consumes = {"application/json"}, produces = {"application/json"})
    public CourierOrderDto changeOrder(@Valid @RequestBody CourierOrderChangeRequest orderChangeRequest) {
        return courierOrderClient.changeOrder(orderChangeRequest);
    }

    @PutMapping(value = "/cancel/{id}")
    public ResponseEntity<Object> cancelOrder(@PathVariable(value = "id") Long parcelId) {
        courierOrderClient.cancelOrder(parcelId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/detail")
    public CourierOrderHistoryDto orderDetail(@RequestParam(name = "id") Long parcelId) {
        return courierOrderClient.orderDetail(parcelId);
    }

    @PostMapping(value = "/history", consumes = {"application/json"}, produces = {"application/json"})
    public List<CourierOrderHistoryDto> orderHistory(@Valid @RequestBody CourierOrderFilter orderFilter) {
        return courierOrderClient.orderHistory(orderFilter);
    }
}
