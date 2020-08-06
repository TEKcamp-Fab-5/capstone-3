import React from "react";
import InventoryView from "./InventoryView";
import ManageInventory from "./ManageInventory";

export default function InventoryManagement(props) {
    const { products, setProducts } = props;
    return (
        <div className="container">
            <div>
                <h2>Inventory Management</h2>
            </div>
            <div
                style={{
                    display: "flex",
                    alignContent: "center",
                    justifyContent: "space-evenly"
                }}
            >
                <InventoryView products={products} setProducts={setProducts} />
                <ManageInventory
                    products={products}
                    setProducts={setProducts}
                />
            </div>
        </div>
    );
}
