(ns park_chatbot.image-recognition
  (:require
    [cortex.util :as util]
    [cortex.nn.execute :as execute]
    [mikera.image.core :as i]
    [think.image.patch :as patch]))

(defn image-file->observation
  "Create an observation from input file."
  [image-path]
 {:labels ["test"]
  :data
   (patch/image->patch
     (-> (i/load-image image-path) (i/resize 52 52))
     :datatype :float
     :colorspace :gray)})

(defn index->class-name[n]
  (nth ["Japanese Spitz" "Rotweiller"] n))

(defn predict [model image-path]
  (let [obs (image-file->observation image-path)]
   (-> (execute/run model [obs])
    first
    :labels
    util/max-index
    index->class-name)))

(def model
  (util/read-nippy-file "trained-network.nippy"))
