import PropTypes from "prop-types";
const Day03Props = function Day03Props(props) {
  // 1st freeze. props is a frozen object, you can del, or update

  console.log("props is freeze or not ", Object.isFrozen(props));
  console.log("I will freeze the props", Object.freeze(props));

  /* 
    2nd seal. Let check if the object is seal or not
    sealed object can update
    sealed object can not be delete
    sealed object can not be add
    sealed object can not be hijack
    */
  console.log("props is sealed or not", Object.isSealed(props));
  console.log("I will seal the props", Object.seal(props));

  /*
    3rd extension
    extended object can update
    extended object can deleted
    extended object can hijack
    extended object can not add
    */
  console.log("props is extened or not", Object.isExtensible(props));
  console.log(
    "I will prevent extend the props",
    Object.preventExtensions(props)
  );

  /*
    props is freeze, seal, and not extended obect, so if you want
    to add and modify the tag properties, you can use the following
    way to implement it.

    This way can transfer the properties in partent component(index.jsx)
    to child component(DemoOne.jsx)
    */
  /*
    If we didnt pass any properties in props, we want to set a 
    default value. React16 will [Component].defaultProps to do 
    the same thing.
    */
  let { customClassName = "defaultClassName", style, title } = props;
  return (
    <div className={`demo-box ${customClassName}`} style={style}>
      <h3 className="title">{title}</h3>
    </div>
  );
};

/*
Rule verification, for example you want to verify the type of
title is string. But you need yarn add prop-types 
import PropTypes from 'prop-types';

Even the type of title is int not string, the porps can also
get it, but you can see an error in th console.
 */
Day03Props.propTypes = {
  title: PropTypes.string.isRequired,
};
export default Day03Props;
