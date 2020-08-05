import React from "react";
import "../styles/Product.css";

export default function Product(props) {
    const { product } = props;
    let imagePath = product.image
        ? require(`../assets/images/${product.image}.png`)
        : null;
    return (
        <div>
            {
                <img
                    key={product.image}
                    src={imagePath}
                    className="img-responsive"
                />
            }
            <p className="product">{product.name.replace(/-/g, " ")}</p>
        </div>
    );
}
