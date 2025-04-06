/*
Static Component - Function Component
Test static component, you can see no matter how you click the 
button, the number in the log will increase, but the page won't
be render again.
*/
const Vote = function vote(props) {
  let { title } = props;
  let sppNum = 0,
    oppNum = 0;

  return (
    <div className="vote-box">
      <div className="header">
        <h2 className="title">{title}</h2>
        <span>Totle Vote Number: {sppNum + oppNum}</span>
      </div>

      <div className="main">
        <p>Support Number : {sppNum}</p>
        <p>Opposite Number: {oppNum}</p>
      </div>

      <div className="footer">
        <button
          onClick={() => {
            sppNum++;
            console.log("Current sppNum: ", sppNum);
          }}
          value="support"
        >
          Support
        </button>
        <button
          onClick={() => {
            oppNum++;
            console.log("Current oppNum: ", oppNum);
          }}
        >
          Opposite
        </button>
      </div>
    </div>
  );
};

export default Vote;
