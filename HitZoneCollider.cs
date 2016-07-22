using UnityEngine;
using UnityEngine.UI;
using System.Collections;

public class HitZoneCollider : MonoBehaviour {

    public GameObject blue, red, green, yellow;
    public Rigidbody blueBody, redBody, greenBody, yellowBody;
    public Text countText;

    protected bool blueHit, redHit, greenHit, yellowHit;
    private int count;

	// Use this for initialization
	void Start () {
        redBody = red.GetComponent<Rigidbody>();
        blueBody = blue.GetComponent<Rigidbody>();
        yellowBody = yellow.GetComponent<Rigidbody>();
        greenBody = green.GetComponent<Rigidbody>();

        count = 0;
        countText.text = "Correct: " + count.ToString();

        redBody.useGravity = false;
        yellowBody.useGravity = false;
        greenBody.useGravity = false;
        blueHit = false;
        redHit = false;
        greenHit = false;
        yellowHit = false;
    }

    void OnTriggerEnter(Collider other)
    {
        if (other.gameObject.CompareTag("Blue Ready"))
        {
            blueHit = true;
            redBody.useGravity = true;
            count += 1;
            countText.text = "Count: " + count.ToString();
        }
        if (other.gameObject.CompareTag("Red Ready"))
        {
            redHit = true;
            greenBody.useGravity = true;
            count += 1;
            countText.text = "Count: " + count.ToString();
        }
        if (other.gameObject.CompareTag("Green Ready"))
        {
            greenHit = true;
            yellowBody.useGravity = true;
            count += 1;
            countText.text = "Count: " + count.ToString();
        }
        if (other.gameObject.CompareTag("Yellow Ready"))
        {
            yellowHit = true;
            count += 1;
            countText.text = "Count: " + count.ToString();
        }
    }

    void OnTriggerExit(Collider other)
    {
        if (other.gameObject.CompareTag("Blue Ready"))
        {
            blueHit = false;
        }
        if (other.gameObject.CompareTag("Red Ready"))
        {
            redHit = false;
        }
        if (other.gameObject.CompareTag("Green Ready"))
        {
            greenHit = false;
        }
        if (other.gameObject.CompareTag("Yellow Ready"))
        {
            yellowHit = false;
        }
    }
    // Update is called once per frame
    void FixedUpdate()
    {
        if (blueHit)
        {
            if (Input.GetKey(KeyCode.Space))
                {
                    Destroy(blue);
                }
        }
        if (redHit)
        {
            if (Input.GetKey(KeyCode.Space))
            {
                Destroy(red);
            }
        }
        if (yellowHit)
        {
            if (Input.GetKey(KeyCode.Space))
            {
                Destroy(yellow);
            }
        }
        if (greenHit)
        {
            if (Input.GetKey(KeyCode.Space))
            {
                Destroy(green);
            }
        }

            if (Input.GetKey(KeyCode.R))
        {
            Destroy(red);
        }
        if (Input.GetKey(KeyCode.B))
        {
            Destroy(blue);
        }
        if (Input.GetKey(KeyCode.G))
        {
            Destroy(green);
        }
        if (Input.GetKey(KeyCode.Y))
        {
            Destroy(yellow);
        }

    }
    }
