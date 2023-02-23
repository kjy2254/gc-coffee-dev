import './App.css';
import 'bootstrap/dist/css/bootstrap.css';
import React, {useEffect, useState} from 'react';
import {ProductList} from "./components/ProductList";
import {Summary} from "./components/Summary";
import axios from "axios";

function App() {
    const [products, setProducts] = useState([]);
    const [items, setItems] = useState([]);

    function handleAddClicked(id) {
        const product = products.find(v => v.productId === id);
        const found = items.find(v => v.productId === id);
        const updatedItems = found ?
            items.map(v => (v.productId === id) ? {...v, count: v.count + 1} : v)
            : [...items, {...product, count: 1}];
        setItems(updatedItems);
    }

    useEffect(() => {
        axios.get('http://localhost:8080/api/v1/products')
            .then(v => {
                setProducts(v.data);
            })
    }, [])

    useEffect(() => {
        console.log("products: ", products);
        console.log("items:", items);
    }, [items])

    function handleOrderSubmit(order) {
        if (items.length === 0) {
            alert("아이템을 추가해 주세요!");
        } else {
            let orderDto = {
                email: order.email,
                address: order.address,
                postcode: order.postcode,
                orderItems: items.map(v => ({
                    productId: v.productId,
                    category: v.category,
                    price: v.price,
                    quantity: v.count
                }))
            }
            console.log(orderDto);
            axios.post('http://localhost:8080/api/v1/orders', orderDto).then(
                v => alert("주문이 정상적으로 접수되었습니다."),
                e => {
                    alert("서버 장애");
                    console.error(e);
                })
        }
    }

    return (<div className="App">
        <div className="container-fluid">
            <div className="row justify-content-center m-4">
                <h1 className="text-center">Grids & Circle</h1>
            </div>
            <div className="card">
                <div className="row">
                    <ProductList products={products} onAddClick={handleAddClicked}/>
                    <Summary items={items} onOrderSubmit={handleOrderSubmit}/>
                </div>
            </div>
        </div>
    </div>);
}

export default App;
