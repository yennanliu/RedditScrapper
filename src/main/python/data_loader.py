import requests, json, logging

def get_data(url):
    r = requests.get(url)
    try:
        json_data = r.json()
        logging.info("load from Reddit API OK")
        return json_data['data']
    except Exception as e:
        logging.error("save from Reddit API failed")

def save_data(json_data, file_name):
    with open(file_name, 'a') as f:
        for i in range(len(json_data)):
            try:
                print (json_data[i])
                f.write(json.dumps(json_data[i]) + "\n")
                logging.info("save file OK")
            except Exception as e:
                logging.error("save file failed")

if __name__ == '__main__':
    print ("collect comment data ...")
    url = "https://api.pushshift.io/reddit/search/comment/?subreddit=TIdaL"
    data_comment = get_data(url)
    #save_data(data_comment, "../../../data/raw/comment.json")
    save_data(data_comment, "data/raw/comment.json")

    print ("collect submission data ...")
    url = "https://api.pushshift.io/reddit/search/submission/?q=TIdaL"
    data_comment = get_data(url)
    #save_data(data_comment, "../../../data/raw/comment.json")
    save_data(data_comment, "data/raw/submission.json")
