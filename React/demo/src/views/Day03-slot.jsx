import React from "react";
/*
If props has children tag, we want to base the number of children
to do make some adjustments. 
*/
const Day03Slot = function Day03Slot(props) {
  let { title, children } = props;

  // Caz children in props can't be updated
  children = React.Children.toArray(children);
  let headerSlot =[], footerSlot = [], defaultSlot = [];
  children.forEach(child => {
    let {slot} = child.props;
    if(slot == 'header'){
        headerSlot.push(child);
    }else if (slot == 'footer'){
        footerSlot.push(child);
    }else{
        defaultSlot.push(child);
    }
  })
  
  return <div className = 'demoslot'>
    {headerSlot.length > 0 ? headerSlot[0] : defaultSlot[0]}
    <div>here are {children.length} children</div>
    {footerSlot.length > 0 ? footerSlot[0] : defaultSlot[1]}
  </div>
};

export default Day03Slot;
